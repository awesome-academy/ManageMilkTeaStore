package app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Category implements Serializable {


    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "parentID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> categories;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
