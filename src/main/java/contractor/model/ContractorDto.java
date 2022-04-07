package contractor.model;

import lombok.*;
@Builder
@Value
public class ContractorDto {
    String name;
    int nip;
    String address;
    int postalCode;
    String city;
    String country;
}
