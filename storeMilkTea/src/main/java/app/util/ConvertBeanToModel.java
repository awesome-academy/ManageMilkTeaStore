package app.util;

import app.bean.CategoryInfo;
import app.bean.RoleInfo;
import app.bean.UserInfo;
import app.model.Category;
import app.model.Role;
import app.model.User;

import java.util.function.Function;

public class ConvertBeanToModel {


    public static Role mapRoleInfoToRole(RoleInfo roleInfo) {
        Function<RoleInfo, Role> map = r -> new Role(r.getId(), r.getName());

        return map.apply(roleInfo);
    }

    public static User mapUserInfoToUser(UserInfo userInfo) {
        Function<UserInfo, User> map = u -> new User(
                u.getId(),
                u.getEmail(),
                u.getPassword(),
                u.isEnable()
        );

        return map.apply(userInfo);
    }

    public static Category mapCategoryInfoToCategory(CategoryInfo categoryInfo) {
        Function<CategoryInfo, Category> map = c -> new Category(c.getId(), c.getName());
        return map.apply(categoryInfo);
    }

}
