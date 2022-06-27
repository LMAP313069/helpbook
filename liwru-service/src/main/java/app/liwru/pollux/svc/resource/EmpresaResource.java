package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Empresa;
import app.liwru.pollux.svc.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/empresas")
@RestController
public class EmpresaResource {

    private final EmpresaService empresaService;

    public EmpresaResource(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        return empresaService.findAll()
                .map(empresas -> empresas.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(empresas, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable int id) {
        return empresaService.findById(id)
                .map(empresa -> new ResponseEntity<>(empresa, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresas) {
        return new ResponseEntity<>(empresaService.saveOrUpdate(empresas), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Empresa> update(@RequestBody Empresa empresas) {
        return new ResponseEntity<>(empresaService.saveOrUpdate(empresas), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmpresa/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (empresaService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
