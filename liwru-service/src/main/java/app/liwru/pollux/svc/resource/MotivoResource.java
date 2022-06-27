package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Motivo;
import app.liwru.pollux.svc.service.MotivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/motivos")
@RestController
public class MotivoResource {

    private final MotivoService motivoService;

    public MotivoResource(MotivoService motivoService) {
        this.motivoService = motivoService;
    }

    @GetMapping
    public ResponseEntity<List<Motivo>> getAll() {
        return motivoService.findAll()
                .map(motivos -> motivos.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(motivos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motivo> getMotivo(@PathVariable int id) {
        return motivoService.findById(id)
                .map(motivo -> new ResponseEntity<>(motivo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Motivo> save(@RequestBody Motivo motivos) {
        return new ResponseEntity<>(motivoService.saveOrUpdate(motivos), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Motivo> update(@RequestBody Motivo motivos) {
        return new ResponseEntity<>(motivoService.saveOrUpdate(motivos), HttpStatus.OK);
    }

    @DeleteMapping("/deleteMotivo/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (motivoService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/deleteMotivo/{id}")
    public ResponseEntity deleteMotivo(@PathVariable int id) {

        if (motivoService.logicDelete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/activeMotivo/{id}")
    public ResponseEntity activeMotivo(@PathVariable int id) {

        if (motivoService.logicActive(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
