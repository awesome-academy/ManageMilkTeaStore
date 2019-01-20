package app.service;

import app.bean.UserInfo;
import app.model.User;
import app.model.VerificationToken;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService extends BaseService<Integer, UserInfo> {

    boolean checkLogin(UserInfo userInfo);

    UserInfo createNewUserAccount(UserInfo userInfo);

    UserInfo getUserByToken(String verificationToken);

    UserInfo createNewUserAccountWithGoogle(UserInfo userInfo);
    
}
