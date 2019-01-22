package app.dao;

import app.model.Size;

import java.util.List;

public interface SizeDAO extends BaseDAO<Integer, Size> {
    List<Size> getSizes();
}
