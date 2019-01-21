package app.service;

import app.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends BaseService<Integer, UserInfo>, UserDetailsService {

    boolean checkLogin(UserInfo userInfo);

    UserInfo createNewUserAccount(UserInfo userInfo);

    UserInfo getUserByToken(String verificationToken);

}
