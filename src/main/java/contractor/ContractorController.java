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
    public ResponseEntity<?> findOne(@PathVariable final int id) {
        logger.info("wyswietlanie uzytkownika o id: " + id);
        return contractorService.findOne(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/create")
    public ResponseEntity<ContractorDto> create(@RequestBody final ContractorDto contractorDto) {
        logger.info("Utworzono kontrahenta o nazwie: " + contractorDto.getName());
        return ResponseEntity.ok(contractorService.create(contractorDto));
    }
    //idempotentny
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody final ContractorDto contractorDto) {
        logger.info("zaktualizowano uzytkownika o id: " + contractorDto.getId());
        return contractorService.update(contractorDto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable final int id) {
        logger.info("Usunieto kontrahenta o id: " + id);
        contractorService.delete(id);
    }
}
