package app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("admin")
@RequestMapping("/admin")
public class HomeController {
    @GetMapping({"","/dashboard"})
    public String index(){
        return "/admin/dashboard";
    }
}
