package app.dao.impl;

import app.dao.CartDetailDAO;
import app.dao.GenericDAO;
import app.model.CartDetail;

import java.util.Date;
import java.util.List;

public class CartDetailDAOImpl extends GenericDAO<Integer, CartDetail> implements CartDetailDAO {
    @Override
    public List<CartDetail> findCartDetailsExpired(Date date) {
        return getSession()
                .createQuery("FROM CartDetail c WHERE c.createdAt <= :date ",CartDetail.class)
                .setParameter("date", date)
                .getResultList();
    }
}
