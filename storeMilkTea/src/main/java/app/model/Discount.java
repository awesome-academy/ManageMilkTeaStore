package app.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Discount implements Serializable {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	private BigDecimal percent;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "discount")
	@Fetch(FetchMode.SELECT)
	@OrderColumn
	private List<Product> products;

}
