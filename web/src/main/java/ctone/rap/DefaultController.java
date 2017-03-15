package ctone.rap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ouyi on 16/5/31.
 */

@Controller
@RequestMapping("/default")
public class DefaultController {
    @RequestMapping(value = "/api.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result api(HttpServletRequest request, HttpServletResponse response) {
        return new Result();
    }

    @RequestMapping(value = "/view.vm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response){
        Result result = new Result();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mav");
        mav.addObject("result",result);
        return mav;
    }
}
