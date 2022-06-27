package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Estado;
import app.liwru.pollux.svc.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/estados")
@RestController
public class EstadoResource {

    private final EstadoService estadoService;

    public EstadoResource(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public ResponseEntity<List<Estado>> getAll() {
        return estadoService.findAll()
                .map(estados -> estados.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(estados, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstado(@PathVariable int id) {
        return estadoService.findById(id)
                .map(estado -> new ResponseEntity<>(estado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody Estado estados) {
        return new ResponseEntity<>(estadoService.saveOrUpdate(estados), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Estado> update(@RequestBody Estado estados) {
        return new ResponseEntity<>(estadoService.saveOrUpdate(estados), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEstado/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (estadoService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
