package app.controller.client;

import app.bean.CategoryInfo;
import app.bean.ProductInfo;
import app.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/")
public class HomeController extends BaseController {
    private static final Logger logger = Logger.getLogger(HomeController.class);

    @GetMapping({"", "home"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("productInfos", productService.loadAllProduct());
        logger.info("home page");
        return modelAndView;
    }

    @GetMapping("/shop")
    public ModelAndView shop() {
        ModelAndView model = new ModelAndView("/shop");
        List<CategoryInfo> categories = categoryService.loadAllCategory();
        model.addObject("categoryInfos", categories);
        return model;
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<ProductInfo> search(@RequestParam String content) {
        return productService.searchProducts(content);
    }

    @GetMapping("/products")
    @ResponseBody
    public List<ProductInfo> products() {
        return productService.loadAllProduct();
    }


}
