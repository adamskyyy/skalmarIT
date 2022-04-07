package contractor.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Contractors")
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contractor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int nip;
    private String address;
    private int postalCode;
    private String city;
    private String country;
    private LocalDateTime creationDate;
    private LocalDateTime versionDate;


}


