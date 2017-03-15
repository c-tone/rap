package ctone.rap.flow;

import ctone.rap.Bean;
import ctone.rap.Flow;
import ctone.rap.Result;
import ctone.rap.component.PlanComponent;

import javax.annotation.Resource;

/**
 * Created by ouyi on 2017/2/27.
 */
public class PlanFlow extends Flow<Bean,Result> {

    @Resource
    private PlanComponent planComponent;

    @Override
    protected Result doFlow(Bean bean) {
        return null;
    }

    public PlanComponent getPlanComponent() {
        return planComponent;
    }

    public void setPlanComponent(PlanComponent planComponent) {
        this.planComponent = planComponent;
    }
}
