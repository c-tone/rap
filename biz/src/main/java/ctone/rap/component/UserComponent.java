package ctone.rap.component;

import ctone.rap.db.module.User;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/26.
 *
 */
public class UserComponent implements Component<User> {

    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    //注销
    public int exit(){
        return 0;
    }
    //入团
    public int intoGroup(){
        return 0;
    }

    //退团
    public int outfGroup(){
        return 0;
    }


    @Override
    public User load(long id) {
        return null;
    }

    @Override
    public List<User> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
