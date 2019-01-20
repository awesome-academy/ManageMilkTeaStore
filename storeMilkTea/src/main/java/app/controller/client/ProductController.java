package app.controller.client;

import app.bean.ProductInfo;
import app.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {
    private static final Logger logger = Logger.getLogger(ProductController.class);
    @Value("${spring.max.result.relate.product}")
    private int maxResultRelateProduct;

    @GetMapping({"", "/all"})
    @ResponseBody
    public List<ProductInfo> products() {
        return productService.loadAllProduct();
    }

    @GetMapping("/{id}")
    public String productDetail(@PathVariable int id, Model model){
        ProductInfo productInfo = productService.findById(id,false);
        model.addAttribute("product", productInfo);
        model.addAttribute("sizes", sizeService.getSizes());
        model.addAttribute("relateProducts", productService.getRelateProducts(productInfo.getCategoryInfo(), maxResultRelateProduct));
        return "/productDetail";
    }
}
