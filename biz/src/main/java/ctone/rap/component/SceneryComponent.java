package ctone.rap.component;

import ctone.rap.db.module.Scenery;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/22.
 */
public class SceneryComponent implements Component<Scenery>{
    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    public int review(){
        return 0;
    }
    //导览
    public Scenery guide(){
        return null;
    }

    @Override
    public Scenery load(long id) {
        return null;
    }

    @Override
    public List<Scenery> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
