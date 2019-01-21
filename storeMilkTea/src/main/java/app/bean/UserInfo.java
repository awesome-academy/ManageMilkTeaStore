package app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"authorities"})
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserInfo implements Serializable {

    private Integer id;
    private String email;
    private String password;
    private boolean enable;

}
