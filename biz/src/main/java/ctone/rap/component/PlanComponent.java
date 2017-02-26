package ctone.rap.component;

import ctone.rap.db.module.Plan;

import java.util.List;
import java.util.Map;

/**
 * Created by ouyi on 2017/2/20.
 */
public class PlanComponent implements Component<Plan>{
    public long add(){
        return 0;
    }

    public int edit(){
        return 0;
    }

    public long copy(){
        return 0;
    }

    public int openMemberSwitch(){
        return 0;
    }

    @Override
    public Plan load(long id) {
        return null;
    }

    @Override
    public List<Plan> list(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public int count(Map<String, Object> conditions) {
        return 0;
    }
}
