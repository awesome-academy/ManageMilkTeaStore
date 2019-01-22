package app.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import app.bean.*;
import app.model.*;

public class ConvertModelToBean {

	public static RoleInfo mapRoleToRoleInfo(Role role) {
		Function<Role, RoleInfo> map = r -> new RoleInfo(r.getId(), r.getName());

		return map.apply(role);
	}

    public static UserInfo mapUserToUserInfo(User user) {
        Function<User, UserInfo> map = u -> new UserInfo(
                u.getId(),
                u.getEmail(),
                u.getPassword(),
                u.isEnable()
                );

		return map.apply(user);
	}

	public static CategoryInfo mapCategoryToCategoryInfo(Category category) {
		Function<Category, CategoryInfo> map = c -> new CategoryInfo(c.getId(), c.getName(),mapProductsToProductInfo(c.getProducts()));
		return map.apply(category);
	}

	public static List<CategoryInfo> mapCategoriesToCategoriesInfos(List<Category> categories) {
		Function<Category, CategoryInfo> mapCategories = c -> new CategoryInfo(c.getId(), c.getName(),mapProductsToProductInfo(c.getProducts()));
		return categories.stream().map(mapCategories).collect(Collectors.toList());
	}

	public static List<ProductInfo> mapProductsToProductInfo(List<Product> products) {
		Function<Product, ProductInfo> mapProductToProductInfo = p -> new ProductInfo(p.getId(), p.getName(), p.getImage(), p.getPrice(),p.getStatus(), mapCategoryToCategoryInfo(p.getCategory()));
		return products.stream().map(mapProductToProductInfo).collect(Collectors.toList());
	}

	public static ProductInfo mapProductToProductInfo(Product product){
		Function<Product, ProductInfo> map = p -> new ProductInfo(p.getId(), p.getName(), p.getImage(), p.getPrice(), p.getStatus(), mapCategoryToCategoryInfo(p.getCategory()));
		return map.apply(product);
	}

	public static List<SizeInfo> mapSizesToSizeInfos(List<Size> sizes){
		Function<Size, SizeInfo> map = s -> new SizeInfo(s.getId(),s.getSize());
		return sizes.stream().map(map).collect(Collectors.toList());
	}
}
