package app.dao;

import app.model.User;

public interface UserDAO extends BaseDAO<Integer, User> {
	User loadUserByEmail(String email);
	boolean checkLogin(User user);
}
