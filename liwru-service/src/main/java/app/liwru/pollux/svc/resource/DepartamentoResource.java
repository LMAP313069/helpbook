package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Departamento;
import app.liwru.pollux.svc.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/departamentos")
@RestController
public class DepartamentoResource {

    private final DepartamentoService departamentoService;

    public DepartamentoResource(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getAll() {
        return departamentoService.findAll()
                .map(departamentos -> departamentos.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(departamentos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamento(@PathVariable int id) {
        return departamentoService.findById(id)
                .map(departamento -> new ResponseEntity<>(departamento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Departamento> save(@RequestBody Departamento departamento) {
        return new ResponseEntity<>(departamentoService.saveOrUpdate(departamento), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDepartamento/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (departamentoService.deleteById( id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
