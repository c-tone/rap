package ctone.rap;

import ctone.rap.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ouyi on 16/5/31.
 */

@Controller
@RequestMapping("/api")
public class DefaultController {
    @RequestMapping(value = "/index.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result index(HttpServletRequest request, HttpServletResponse response) {
        return new Result();
    }
}
