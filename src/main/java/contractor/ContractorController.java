package contractor;


import contractor.domain.Contractor;
import contractor.domain.ContractorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RequestMapping(value = "/contractor")
@RepositoryRestController
public class ContractorController {

    private static final Logger logger = LoggerFactory.getLogger(ContractorController.class);

    @Autowired
    private ContractorService service;

    @GetMapping("/findOne/{id}")
    public Contractor findOne(@PathVariable int id) {
        logger.info("wyswietlanie uzytkownika o id: " + id);
        return this.service.findOne(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }



    @GetMapping("/findAll")
    public List<Contractor> findAll(@RequestBody List<Contractor> contractorList) {
        logger.info("Wyswietlono liste kontrahentow");
        return service.findAll();
    }

    @PostMapping("/create")
    public Contractor create(@RequestBody Contractor contractor) {
        logger.info("Utworzono kontrahenta o id: " + contractor.getId());
        return service.create(contractor);
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
