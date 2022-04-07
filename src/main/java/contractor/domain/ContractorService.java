package contractor.domain;

import contractor.model.ContractorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
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
        Contractor contractorToCreate = new Contractor();
                contractorToCreate.setName(receivedContractor.getName());
                contractorToCreate.setNip(receivedContractor.getNip());
                contractorToCreate.setAddress(receivedContractor.getAddress());
                contractorToCreate.setPostalCode(receivedContractor.getPostalCode());
                contractorToCreate.setCity(receivedContractor.getCity());
                contractorToCreate.setCountry(receivedContractor.getCountry());
                contractorToCreate.setCreationDate(LocalDateTime.now());
                contractorToCreate.setVersionDate(LocalDateTime.now());
        contractorRepository.save(contractorToCreate);
        return receivedContractor;
    }

    public void delete(int id) {
        contractorRepository.deleteById(id);
    }

    public ContractorDto update(Contractor contractor) {
        Contractor existingContractor = contractorRepository.findById(contractor.getId()).orElseThrow(() -> new NoSuchElementException("not found"));
        existingContractor.setName(contractor.getName());
        existingContractor.setNip(contractor.getNip());
        existingContractor.setAddress(contractor.getAddress());
        existingContractor.setPostalCode(contractor.getPostalCode());
        existingContractor.setCity(contractor.getCity());
        existingContractor.setCountry(contractor.getCountry());
        existingContractor.setVersionDate(LocalDateTime.now());
        contractorRepository.save(existingContractor);
        return this.toDto(contractor);
    }

}
