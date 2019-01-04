package app.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	private String email;

	@NonNull
	private String password;

	@NonNull
	private String fullName;

	@NonNull
	private String phone;

	@NonNull
	private String gender;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "roleID", nullable = false)
	private Role role;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@Fetch(FetchMode.SELECT)
	@OrderColumn
	private List<Review> reviews;

	@OneToOne(mappedBy = "user")
	private Cart cart;
}
