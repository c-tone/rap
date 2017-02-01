package ctone.rap.controller;

import ctone.rap.bean.Bean;
import ctone.rap.result.Result;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ouyi on 16/9/26.
 */
public abstract class Flow {
    private static final Logger logger = LoggerFactory.getLogger(Flow.class);

    protected void execute(HttpServletRequest request, HttpServletResponse response){
        try {
            Bean bean = newBean(request);
            Result result = newResult();
            doFlow(bean,result);
        }catch (Throwable t){
            handleThrowable(t);
        }
    }
    protected Bean newBean(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
        Bean bean = new Bean();
        BeanUtils.populate(bean, request.getParameterMap());
        return bean;
    }
    protected Result newResult(){
        return new Result();
    }

    protected abstract void doFlow(Bean bean,Result result);


    protected void handleThrowable(Throwable t){
        logger.error("execute error !",t);
    }

}
