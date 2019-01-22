package app.service;

import app.bean.CategoryInfo;
import app.bean.ProductInfo;

import java.util.List;

public interface ProductService extends BaseService<Integer, ProductInfo> {
    List<ProductInfo> loadAllProduct();

    List<ProductInfo> searchProducts(String name);

    List<ProductInfo> getRelateProducts(CategoryInfo categoryInfo, int maxResult);
}
