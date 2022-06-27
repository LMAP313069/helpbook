package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Distrito;
import app.liwru.pollux.svc.service.DistritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/distritos")
@RestController
public class DistritoResource {

    private final DistritoService distritoService;

    public DistritoResource(DistritoService distritoService) {
        this.distritoService = distritoService;
    }


    @GetMapping
    public ResponseEntity<List<Distrito>> getAll() {
        return distritoService.findAll()
                .map(distritos -> distritos.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(distritos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distrito> getDistrito(@PathVariable int id) {
        return distritoService.findById(id)
                .map(distrito -> new ResponseEntity<>(distrito, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Distrito> save(@RequestBody Distrito distritos) {
        return new ResponseEntity<>(distritoService.saveOrUpdate(distritos), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDistrito/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (distritoService.deleteById( id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
