package app.dao.impl;

import app.dao.GenericDAO;
import app.dao.SizeDAO;
import app.model.Size;

import java.io.Serializable;
import java.util.List;

public class SizeDAOImpl extends GenericDAO<Integer, Size> implements SizeDAO {

    @Override
    public void delete(Size entity) {

    }

    @Override
    public Size saveOrUpdate(Size entity) {
        return null;
    }

    @Override
    public Size findById(Serializable key) {
        return null;
    }

    @Override
    public List<Size> getSizes() {
        return getSession().createQuery("FROM Size s ORDER BY s.size DESC ",Size.class).getResultList();
    }
}
