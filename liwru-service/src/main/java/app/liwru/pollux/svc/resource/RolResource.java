package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Rol;
import app.liwru.pollux.svc.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/roles")
@RestController
public class RolResource {

    private final RolService rolService;

    public RolResource(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getAll() {
        return rolService.findAll()
                .map(roles -> roles.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(roles, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRol(@PathVariable int id) {
        return rolService.findById(id)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rol> save(@RequestBody Rol roles) {
        return new ResponseEntity<>(rolService.saveOrUpdate(roles), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Rol> update(@RequestBody Rol roles) {
        return new ResponseEntity<>(rolService.saveOrUpdate(roles), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRol/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (rolService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
