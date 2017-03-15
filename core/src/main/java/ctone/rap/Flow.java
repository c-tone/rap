package ctone.rap;

import ctone.rap.constant.Status;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by ouyi on 16/9/26.
 */
public abstract class Flow<BEAN extends Bean, RESULT extends Result> {
    private static final Logger logger = LoggerFactory.getLogger(Flow.class);

    /**
     * 执行流程
     *
     * @param request
     */
    public RESULT execute(HttpServletRequest request) {
        BEAN bean = null;
        RESULT result = null;
        try {
            bean = newBean(request);
            result = doFlow(bean);
        } catch (Throwable t) {
            logger.error("execute error !", t);
            handleThrowable(result);
        }
        return result;
    }

    /**
     * 创建Bean
     *
     * @param request
     */
    protected BEAN newBean(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException, InstantiationException, BeanException {
        Type[] types = getGenericTypes(this.getClass());
        Type type = null;
        for (Type item : types) {
            if (item instanceof Bean) {
                type = item;
                break;
            }
        }
        if (type == null) {
            throw new BeanException("newBean error:type is null!");
        }
        BEAN bean = (BEAN) type.getClass().newInstance();
        BeanUtils.populate(bean, request.getParameterMap());
        return bean;

    }

    /**
     * 具体流程
     *
     * @param bean
     * @return Result
     */
    protected abstract RESULT doFlow(BEAN bean);

    /**
     * 异常处理
     *
     * @param result
     */
    protected void handleThrowable(Result result) {
        result.setStatus(Status.FAIL);
    }

    /**
     * 取实现类的泛型数组
     *
     * @return 泛型数组
     */
    public Type[] getGenericTypes(Class<?> clazz) {
        if (clazz.getSuperclass().getName().equals(Object.class.getName())) {
            throw new UnsupportedOperationException("this is a sub instance of Object");
        }

        Type type;
        do {
            // 取泛型参数
            type = clazz.getGenericSuperclass();
            clazz = clazz.getSuperclass();
        }
        // 从当前类向上，直到找到泛型类
        while (!(type instanceof ParameterizedType));
        // 取泛型集合
        return ((ParameterizedType) type).getActualTypeArguments();
    }

}
