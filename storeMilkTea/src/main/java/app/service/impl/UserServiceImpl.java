package app.service.impl;

import app.bean.CustomUserDetails;
import app.bean.UserInfo;
import app.model.User;
import app.model.VerificationToken;
import app.service.UserService;
import app.util.ConvertBeanToModel;
import app.util.ConvertModelToBean;
import app.util.UserUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl extends BaseServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public UserInfo findById(Serializable key, boolean lock) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserInfo saveOrUpdate(UserInfo entity) {
        try {
            User user = userDAO.findById(entity.getId());
            user.setEnable(entity.isEnable());
            return ConvertModelToBean
                    .mapUserToUserInfo(userDAO
                            .saveOrUpdate(user));

        } catch (Exception e) {
            logger.error("Hibernate exception " + e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean delete(UserInfo entity) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean checkLogin(UserInfo userInfo) {
        try {

            return userDAO.checkLogin(ConvertBeanToModel.mapUserInfoToUser(userInfo));
        } catch (Exception e) {
            logger.error("Hibernate exception " + e.getMessage());
            return false;
        }

    }

    @Override
    public UserInfo createNewUserAccount(UserInfo userInfo) {

        try {
            if (!UserUtils.checkFormatUser(userInfo))
                return null;

            if (!emailExist(userInfo.getEmail()))
                return null;

            User user = userDAO.saveOrUpdate(convertNewUserUtils.convertNewUser(userInfo));
            if (user == null)
                return null;

            String token = UUID.randomUUID().toString();
            if (verificationTokenDAO.saveOrUpdate(new VerificationToken(token, user)) == null)
                throw new NullPointerException("Can't generator Token for " + user.toString());

            return ConvertModelToBean.mapUserToUserInfo(user);
        } catch (Exception e) {
            logger.error("Hibernate exception " + e.getMessage());
            throw e;
        }
    }

    @Override
    public UserInfo getUserByToken(String verificationToken) {
        try {
            return ConvertModelToBean
                    .mapUserToUserInfo(verificationTokenDAO.findByToken(verificationToken).getUser());

        } catch (Exception e) {
            logger.error("Hibernate exception " + e.getMessage());
            return null;
        }
    }


    private boolean emailExist(String email) {
        try {
            return userDAO.loadUserByEmail(email) == null;
        } catch (Exception e) {
            logger.error("Hibernate exception " + e.getMessage());
            return false;
        }

    }

    private CustomUserDetails setUserDetail(User user) {
        CustomUserDetails userDetail = new CustomUserDetails();
        userDetail.setId(user.getId());
        userDetail.setEmail(user.getEmail());
        userDetail.setPassword(user.getPassword());
        return userDetail;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userDAO.loadUserByEmail(username);
            CustomUserDetails userDetail = setUserDetail(user);
            userDetail.setUsername(username);
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
            userDetail.setAuthorities(authorities);

            BeanUtils.copyProperties(user, userDetail);

            return userDetail;
        } catch (Exception e) {
            logger.error(e);
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
    }
}
