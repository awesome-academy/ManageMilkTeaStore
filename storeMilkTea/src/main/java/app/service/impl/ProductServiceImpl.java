package app.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import app.bean.ProductInfo;
import app.service.ProductService;
import app.util.ConvertModelToBean;
import org.apache.log4j.Logger;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public ProductInfo findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInfo saveOrUpdate(ProductInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ProductInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<ProductInfo> searchProducts(String content) {
		try {
			return ConvertModelToBean.mapProductsToProductInfo(productDAO.searchProducts(content));

		} catch (Exception e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return Collections.emptyList();
		}
	}

	@Override
	public List<ProductInfo> loadAllProduct() {
		try {
			return ConvertModelToBean.mapProductsToProductInfo(productDAO.loadAllProduct());
			
		} catch (Exception e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return Collections.emptyList();
		}
		
	}

}
