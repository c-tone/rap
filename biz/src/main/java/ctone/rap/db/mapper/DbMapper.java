package ctone.rap.db.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/20.
 */
public interface DbMapper<T> {
    long create(T t);
    int modify(T t);
    int remove(long id);
    List<T> list(String[] fields,Map<String,Object> conditions,String group,int start,int pageSize,String order);
    int count(Map<String,Object> conditions);
    T one(long id);
    List<T> all();
    int total();
}
