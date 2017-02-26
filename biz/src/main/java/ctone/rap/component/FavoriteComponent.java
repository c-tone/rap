package ctone.rap.component;

import ctone.rap.db.module.Favorite;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/20.
 */
public class FavoriteComponent  implements Component<Favorite>{
    public long like(){
        return 0;
    }

    public int cancel(){
        return 0;
    }

    @Override
    public Favorite load(long id) {
        return null;
    }

    @Override
    public List<Favorite> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
