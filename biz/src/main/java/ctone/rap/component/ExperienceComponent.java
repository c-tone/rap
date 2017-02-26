package ctone.rap.component;

import ctone.rap.db.module.Experience;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/26.
 */
public class ExperienceComponent implements Component<Experience> {
    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    //检查
    public int check(){
        return 0;
    }

    //提交
    public int submit(){
        return 0;
    }

    public int delete(){
        return 0;
    }

    @Override
    public Experience load(long id) {
        return null;
    }

    @Override
    public List<Experience> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
