package contractor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ContractorDto {

    private String name;
    private int nip;
    private String address;
    private int postalCode;
    private String city;
    private String country;



}
