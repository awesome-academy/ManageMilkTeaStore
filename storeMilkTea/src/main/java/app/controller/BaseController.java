package app.controller;

import app.service.CategoryService;
import app.service.ProductService;
import app.service.UserService;
import app.service.VerificationTokenService;
import app.util.EmailUtils;
import app.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class BaseController {
    @Autowired
    protected UserService userService;
    @Autowired
    protected JWTUtils jwtUtils;
    @Autowired
    protected ReloadableResourceBundleMessageSource messageSource;
    @Autowired
    protected EmailUtils emailUtils;
    @Autowired
    protected VerificationTokenService verificationTokenService;
    @Autowired
    protected ProductService productService;
    @Autowired 
    protected CategoryService categoryService;


}
