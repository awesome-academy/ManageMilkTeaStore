package app.dao;

import java.util.List;

import app.model.Product;

public interface ProductDAO extends BaseDAO<Integer, Product> {
	List<Product> loadAllProduct();
	List<Product> searchProducts(String content) throws InterruptedException;
	void resetIndexs();

}
