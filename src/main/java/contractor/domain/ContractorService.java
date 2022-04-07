package contractor.domain;

import contractor.model.ContractorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractorService {

    private final ContractorRepository contractorRepository;

    private ContractorDto toDto(Contractor contractor) {
        return ContractorDto.builder()
                .name(contractor.getName())
                .nip(contractor.getNip())
                .address(contractor.getAddress())
                .postalCode(contractor.getPostalCode())
                .city(contractor.getCity())
                .country(contractor.getCountry())
                .build();
    }

    public List<ContractorDto> findAll() {
        return contractorRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Optional<ContractorDto> findOne(int id) {
        return contractorRepository.findById(id).map(this::toDto);
    }

    public ContractorDto create(ContractorDto receivedContractor) {
        Contractor contractorToCreate = Contractor.builder()
                .name(receivedContractor.getName())
                .nip(receivedContractor.getNip())
                .address(receivedContractor.getAddress())
                .postalCode(receivedContractor.getPostalCode())
                .city(receivedContractor.getCity())
                .country(receivedContractor.getCountry())
                .creationDate(LocalDateTime.now())
                .versionDate(LocalDateTime.now())
                .build();
        contractorRepository.save(contractorToCreate);
        return receivedContractor;
    }

    public void delete(int id) {
        contractorRepository.deleteById(id);
    }

    public Optional<ContractorDto> update(ContractorDto contractorDto) {
       return contractorRepository.findById(contractorDto.getId())
                .map(existingContractor -> existingContractor.toBuilder()
                        .name(contractorDto.getName())
                        .nip(contractorDto.getNip())
                        .address(contractorDto.getAddress())
                        .postalCode(contractorDto.getPostalCode())
                        .city(contractorDto.getCity())
                        .country(contractorDto.getCountry())
                        .versionDate(LocalDateTime.now())
                        .build())
                .map(contractorRepository::save)
                .map(this::toDto);
    }
}

//konstruktor kopiujący