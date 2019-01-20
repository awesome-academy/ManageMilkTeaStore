package app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductInfo {
    private Integer id;
    private String name;
    private String image;
    private BigDecimal price;
    private Integer status;
    private CategoryInfo categoryInfo;
}
