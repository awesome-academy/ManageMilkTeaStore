package app.dao.impl;

import app.dao.GenericDAO;
import app.dao.UserDAO;
import app.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {



    @Override
    public boolean checkLogin(User checkAccount) {
        User user = getSession().createQuery("FROM User u WHERE u.email =:email,", User.class).uniqueResult();
        return user == null ? false : true;
    }


    @Override
    public User loadUserByEmail(String email) {
        return   getSession().createQuery("FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email).uniqueResult();
    }

}
