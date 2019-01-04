package app.service;

import app.bean.UserInfo;

public interface UserService extends BaseService<Integer, UserInfo> {
	boolean checkLogin(UserInfo userInfo);
	boolean createUser(UserInfo userInfo);
}
