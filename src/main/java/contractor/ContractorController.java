package contractor;


import contractor.domain.Contractor;
import contractor.domain.ContractorService;
import contractor.model.ContractorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/contractor")
@RestController
public class ContractorController {

    private static final Logger logger = LoggerFactory.getLogger(ContractorController.class);

    private final ContractorService service;

    public ContractorController(ContractorService service) {
        this.service = service;
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<ContractorDto>> findAllDto() {
        logger.info("Wyswietlono liste kontrahentow");
        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(service::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<ContractorDto> findOneDto(@PathVariable int id) {
        logger.info("wyswietlanie uzytkownika o id: " + id);
        return ResponseEntity.ok(service.toDto(service.findOne(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found");
        })));
    }

    @PostMapping("/create")
    public ResponseEntity<Contractor> create(@RequestBody Contractor contractor) {
        logger.info("Utworzono kontrahenta o id: " + contractor.getId());
        return ResponseEntity.ok(service.create(contractor));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Usunieto kontrahenta o id: " + id);
        service.delete(id);
    }

    @PutMapping("/update")
    public void update(Contractor contractor) {
        logger.info("zaktualizowano uzytkownika o id: " + contractor.getId());
        service.update(contractor);
    }


}
