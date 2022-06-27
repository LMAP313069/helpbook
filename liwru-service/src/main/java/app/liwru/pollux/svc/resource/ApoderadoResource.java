package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Apoderado;
import app.liwru.pollux.svc.service.ApoderadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/apoderados")
@RestController
public class ApoderadoResource {

    private final ApoderadoService apoderadoService;

    public ApoderadoResource(ApoderadoService apoderadoService) {
        this.apoderadoService = apoderadoService;
    }

    @GetMapping
    public ResponseEntity<List<Apoderado>> getAll() {
        return apoderadoService.findAll()
                .map(apoderados -> apoderados.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(apoderados, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apoderado> getApoderado(@PathVariable int id) {
        return apoderadoService.findById( id)
                .map(apoderado -> new ResponseEntity<>(apoderado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Apoderado> save(@RequestBody Apoderado apoderado) {
        return new ResponseEntity<>(apoderadoService.saveOrUpdate(apoderado), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Apoderado> update(@RequestBody Apoderado apoderado) {
        return new ResponseEntity<>(apoderadoService.saveOrUpdate(apoderado), HttpStatus.OK);
    }

    @DeleteMapping("/deleteApoderado/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (apoderadoService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
