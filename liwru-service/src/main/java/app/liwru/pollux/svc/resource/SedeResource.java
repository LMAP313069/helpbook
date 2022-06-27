package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Sede;
import app.liwru.pollux.svc.service.SedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/sedes")
@RestController
public class SedeResource {

    private final SedeService sedeService;

    public SedeResource(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @GetMapping
    public ResponseEntity<List<Sede>> getAll() {
        return sedeService.findAll()
                .map(sedes -> sedes.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(sedes, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> getSede(@PathVariable int id) {
        return sedeService.findById(id)
                .map(sede -> new ResponseEntity<>(sede, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Sede> save(@RequestBody Sede sedes) {
        return new ResponseEntity<>(sedeService.saveOrUpdate(sedes), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Sede> update(@RequestBody Sede sedes) {
        return new ResponseEntity<>(sedeService.saveOrUpdate(sedes), HttpStatus.OK);
    }

    @PutMapping("/deleteSede/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (sedeService.logicDelete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/activeSede/{id}")
    public ResponseEntity active(@PathVariable int id) {

        if (sedeService.logicActive(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
