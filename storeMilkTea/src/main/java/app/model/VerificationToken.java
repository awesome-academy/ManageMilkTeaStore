package app.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verificationToken")
@Data
@NoArgsConstructor
public class VerificationToken implements Serializable {

    @Value("${spring.email.token.expiration}")
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Transient
    private int expiration;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private User user;

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public VerificationToken(String token, User user) {
        this.expiryDate = calculateExpiryDate(expiration);
        this.token = token;
        this.user = user;
    }

}
