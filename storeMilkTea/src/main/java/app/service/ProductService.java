package app.service;

import java.util.List;

import app.bean.ProductInfo;

public interface ProductService extends BaseService<Integer, ProductInfo> {
	List<ProductInfo> loadAllProduct();
	List<ProductInfo> searchProducts(String name);

}
