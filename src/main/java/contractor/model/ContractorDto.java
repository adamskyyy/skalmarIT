package contractor.model;

import lombok.*;
@Builder
@Value
public class ContractorDto {
    int id;
    String name;
    int nip;
    String address;
    int postalCode;
    String city;
    String country;
}
