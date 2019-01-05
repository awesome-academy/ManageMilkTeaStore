package app.service.impl;

import app.bean.UserInfo;
import app.model.User;
import app.service.UserService;
import app.util.ConvertBeanToModel;
import app.util.UserUtils;

import java.io.Serializable;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public UserInfo findById(Serializable key, boolean lock) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserInfo saveOrUpdate(UserInfo entity) {
        // TODO Auto-generated method stub
        return null;
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

            return false;
        }

    }

    @Override
    public boolean createUser(UserInfo userInfo) {
        try {
            if (UserUtils.checkUserInfo(userInfo)) {
                if (userDAO.loadUserByEmail(userInfo.getEmail()) == null) {
                    User user = convertPasswordUtils.convertNewUser(userInfo);
                    return userDAO.saveOrUpdate(user) != null;
                } else return false;

            } else return false;
        } catch (Exception e) {

            return false;
        }
    }

}
