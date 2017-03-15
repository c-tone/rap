package ctone.rap;

import ctone.rap.flow.PlanFlow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ouyi on 16/5/31.
 */

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Resource
    private PlanFlow planFlow;

    @RequestMapping(value = "/create.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result create(HttpServletRequest request, HttpServletResponse response) {
        return planFlow.execute(request);
    }

    public PlanFlow getPlanFlow() {
        return planFlow;
    }

    public void setPlanFlow(PlanFlow planFlow) {
        this.planFlow = planFlow;
    }
}
