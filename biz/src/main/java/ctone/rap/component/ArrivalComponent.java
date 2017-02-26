package ctone.rap.component;

import ctone.rap.db.module.Arrival;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/20.
 */
public class ArrivalComponent  implements Component<Arrival>{
    public long arrive(){
        return 0;
    }

    public int cancel(){
        return 0;
    }

    @Override
    public Arrival load(long id) {
        return null;
    }

    @Override
    public List<Arrival> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
