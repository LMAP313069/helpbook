package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Provincia;
import app.liwru.pollux.svc.service.ProvinciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/provincias")
@RestController
public class ProvinciaResource {

    private final ProvinciaService provinciaService;

    public ProvinciaResource(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping
    public ResponseEntity<List<Provincia>> getAll() {
        return provinciaService.findAll()
                .map(provincias -> provincias.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(provincias, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> getProvincia(@PathVariable int id) {
        return provinciaService.findById(id)
                .map(provincia -> new ResponseEntity<>(provincia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Provincia> save(@RequestBody Provincia provincias) {
        return new ResponseEntity<>(provinciaService.saveOrUpdate(provincias), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProvincia/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (provinciaService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
