package ctone.rap.component;

import ctone.rap.db.module.Label;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/26.
 */
public class LabelComponent implements Component<Label>{
    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    public int delete(){
        return 0;
    }

    //帖标
    public int attach(){
        return 0;
    }
    //去标
    public int remove(){
        return 0;
    }

    @Override
    public Label load(long id) {
        return null;
    }

    @Override
    public List<Label> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
