package app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"roles", "authorities"})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInfo implements Serializable {

    private Integer id;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private String gender;
    private RoleInfo role;

}
