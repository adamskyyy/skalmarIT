package contractor.domain;

import lombok.*;
import org.springframework.stereotype.Component;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "Contractors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Contractor {
    @Id
    @GeneratedValue
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


