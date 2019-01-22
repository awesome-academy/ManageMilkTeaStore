package app.dao;

import java.util.List;

import app.model.Category;
import app.model.Product;

public interface ProductDAO extends BaseDAO<Integer, Product> {
	List<Product> loadAllProduct();
	List<Product> searchProducts(String content) throws InterruptedException;
	void resetIndexs();
	List<Product> getRelateProducts(Category category, int maxResult);

}
