package contractor.domain;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {


    private final ContractorRepository repository;

    public ContractorService(ContractorRepository repository) {
        this.repository = repository;
    }

    public List<Contractor> findAll() {
        return repository.findAll();
    }

    public Optional<Contractor> findOne(int id) {
        return repository.findById(id);
    }

    public Contractor create(Contractor contractor) {
        return repository.save(contractor);
    }


    public void delete(int id) {
        repository.deleteById(id);
    }

    public void update(Contractor contractor) {
        Contractor existingContractor = repository.findById(contractor.getId()).orElse(null);
        existingContractor.setName(contractor.getName());
        existingContractor.setNip(contractor.getNip());
        existingContractor.setAddress(contractor.getAddress());
        existingContractor.setPostalCode(contractor.getPostalCode());
        existingContractor.setCity(contractor.getCity());
        existingContractor.setCountry(contractor.getCountry());
        existingContractor.setVersionDate(LocalDate.now());
        repository.save(existingContractor);
    }


}
