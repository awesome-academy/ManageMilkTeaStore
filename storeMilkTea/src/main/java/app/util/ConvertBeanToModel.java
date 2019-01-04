package app.util;

import app.bean.RoleInfo;
import app.bean.UserInfo;
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
                u.getFullName(),
                u.getPhone(),
                u.getGender(),
                mapRoleInfoToRole(u.getRole()));

        return map.apply(userInfo);
    }
}
