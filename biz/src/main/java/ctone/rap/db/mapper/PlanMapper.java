package ctone.rap.db.mapper;

import ctone.rap.db.module.Plan;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/20.
 */
public interface PlanMapper extends DbMapper<Plan>{
    @Insert("")
    @Override
    long create(Plan plan);

    @Update("")
    @Override
    int modify(Plan plan);

    @Update("")
    @Override
    int remove(long id);

    //@SelectProvider()
    @Results({})
    @Override
    List<Plan> list(String[] fields, Map<String, Object> conditions, String group, int start, int pageSize, String order);

    @Select("select count(id) from ? where ?")
    @Override
    int count(Map<String, Object> conditions);

    @Select("select * from ? where id=")
    @Results({})
    @Override
    Plan one(long id);

    @Select("select * from ?")
    @Results({})
    @Override
    List<Plan> all();

    @Select("select count(id) from ?")
    @Override
    int total();
}
