package contractor;

import contractor.domain.Contractor;
import contractor.domain.ContractorService;
import contractor.model.ContractorDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/contractor")
@RestController
@RequiredArgsConstructor
public class ContractorController {

    private static final Logger logger = LoggerFactory.getLogger(ContractorController.class);

    private final ContractorService contractorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ContractorDto>> findAll() {
        logger.info("Wyswietlono liste kontrahentow");
        return ResponseEntity.ok(contractorService.findAll());
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Optional<ContractorDto>> findOne(@PathVariable int id) {
        logger.info("wyswietlanie uzytkownika o id: " + id);
        if(contractorService.findOne(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contractorService.findOne(id));
    }


    @PostMapping("/create")
    public ResponseEntity<ContractorDto> create(@RequestBody ContractorDto contractorDto) {
        logger.info("Utworzono kontrahenta o nazwie: " + contractorDto.getName());
        return ResponseEntity.ok(contractorService.create(contractorDto));
    }

    @PatchMapping("/update")
    public ResponseEntity<ContractorDto> update(@RequestBody Contractor contractor) {
        logger.info("zaktualizowano uzytkownika o id: " + contractor.getId());
        return ResponseEntity.ok(contractorService.update(contractor));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Usunieto kontrahenta o id: " + id);
        contractorService.delete(id);
    }
}
