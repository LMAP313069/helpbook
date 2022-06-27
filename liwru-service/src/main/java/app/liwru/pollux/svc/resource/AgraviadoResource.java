package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Agraviado;
import app.liwru.pollux.svc.model.Usuario;
import app.liwru.pollux.svc.service.AgraviadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*")
@RequestMapping("/api/agraviados")
@RestController
public class AgraviadoResource {

    private final AgraviadoService agraviadoService;

    public AgraviadoResource(AgraviadoService agraviadoService) {
        this.agraviadoService = agraviadoService;
    }

    @GetMapping
    public ResponseEntity<List<Agraviado>> getAll() {
        return agraviadoService.findAll()
                .map(agraviados -> agraviados.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(agraviados, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agraviado> getAgraviado(@PathVariable int id) {
        return agraviadoService.findById( id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Agraviado> save(@RequestBody Agraviado user) {
        return new ResponseEntity<>(agraviadoService.saveOrUpdate(user), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Agraviado> update(@RequestBody Agraviado user) {
        user.setDistrito(null);
        return new ResponseEntity<>(agraviadoService.saveOrUpdate(user), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAgraviado/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (agraviadoService.logicDelete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/last")
    public ResponseEntity<Agraviado> getLastAgraviado() {
        return agraviadoService.findLast()
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
