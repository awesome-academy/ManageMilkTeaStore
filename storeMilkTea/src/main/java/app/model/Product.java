package app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Indexed
@Data
@NoArgsConstructor

public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @SortableField
    @Field(termVector = TermVector.YES, store = Store.YES)
    private String name;

    private String image;

    private BigDecimal price;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

}
