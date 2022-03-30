package contractor.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="Contractors")
@Getter
@Data


public class Contractor{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int nip;
    private String address;
    private int postalCode;
    private String city;
    private String country;
    private LocalDate creationDate;
    private LocalDate versionDate;


}


