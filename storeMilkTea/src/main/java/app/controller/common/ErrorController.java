package app.controller.common;

import app.util.RequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest request) {
        String url = request.getRequestURL().toString().contains("admin") ? "/admin" : "/";
        switch (RequestUtils.getErrorCode(request)) {
            case 404:
                return new ModelAndView("/error/pages/404").addObject("homePage",url);

            case 500:
                return new ModelAndView("/error/pages/500").addObject("homePage",url);

            default:
                return new ModelAndView("/error/pages/undefined").addObject("homePage",url);

        }
    }
}
