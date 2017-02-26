package ctone.rap.component;

import ctone.rap.db.module.Group;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/22.
 * group:user = n:m
 */
public class GroupComponent implements Component<Group>{
    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    //设置管理员
    public int setAdmin(){
        return 0;
    }

    //设置群主
    public int setLord(){
        return 0;
    }

    //保存公告
    public int savennouncement(){
        return 0;
    }

    public int total(){
        return 0;
    }

    public int getLeaving(){
        return 0;
    }

    @Override
    public Group load(long id) {
        return null;
    }

    @Override
    public List<Group> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
