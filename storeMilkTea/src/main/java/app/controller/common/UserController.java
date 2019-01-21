package app.controller.common;

import app.bean.UserInfo;
import app.controller.BaseController;
import app.model.User;
import app.model.VerificationToken;
import app.util.ConvertModelToBean;
import app.util.DateTimeUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInfo userInfo) {

        try {
            if (!userService.checkLogin(userInfo))
                return new ResponseEntity<>("Wrong userId and password", HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(jwtUtils.generateTokenLogin(userInfo.getEmail()), HttpStatus.OK);

        } catch (Exception ex) {
            logger.error("Server error: " + ex.getMessage());
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserInfo userInfo, WebRequest request) {

        UserInfo registered = userService.createNewUserAccount(userInfo);
        if (registered == null)
            return new ResponseEntity<>("fail", HttpStatus.NOT_ACCEPTABLE);

        emailUtils.sendConfirmationEmail(
                registered.getEmail(),
                verificationTokenService.getVerificationTokenbyUser(registered),
                request);
        return new ResponseEntity<>("successful", HttpStatus.OK);
    }

    @GetMapping("/registrationConfirm")
    public ModelAndView confirmRegistration
            (@RequestParam("token") String token) {

        ModelAndView view = new ModelAndView("/confirm");
        String status;
        VerificationToken verificationToken = verificationTokenService.getVerificationToken(token);
        if (verificationToken == null)
            status = "NotFound";

        if (verificationToken.getUser().isEnable())
            status = "Already";

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((DateTimeUtils
                .convertUTCToLocal(verificationToken
                        .getExpiryDate().getTime()) - cal.getTime().getTime()) <= 0)
            status = "Expired";

        user.setEnable(true);
        userService.saveOrUpdate(ConvertModelToBean.mapUserToUserInfo(user));
        status = "Successful";
        view.addObject("status", status);
        logger.info("Account authentication status " + verificationToken.getUser().getEmail() + " is " + status);
        return view;
    }

}
