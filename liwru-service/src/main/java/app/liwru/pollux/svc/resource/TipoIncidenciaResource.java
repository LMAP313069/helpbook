package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.TipoIncidencia;
import app.liwru.pollux.svc.service.TipoIncidenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tipos-incidencias")
@RestController
public class TipoIncidenciaResource {

    private final TipoIncidenciaService tipoIncidenciaService;

    public TipoIncidenciaResource(TipoIncidenciaService tipoIncidenciaService) {
        this.tipoIncidenciaService = tipoIncidenciaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoIncidencia>> getAll() {
        return tipoIncidenciaService.findAll()
                .map(tipoIncidencias -> tipoIncidencias.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(tipoIncidencias, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoIncidencia> getTipoIncidencia(@PathVariable int id) {
        return tipoIncidenciaService.findById(id)
                .map(tipoIncidencia -> new ResponseEntity<>(tipoIncidencia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoIncidencia> save(@RequestBody TipoIncidencia tipoIncidencias) {
        return new ResponseEntity<>(tipoIncidenciaService.saveOrUpdate(tipoIncidencias), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<TipoIncidencia> update(@RequestBody TipoIncidencia tipoIncidencias) {
        return new ResponseEntity<>(tipoIncidenciaService.saveOrUpdate(tipoIncidencias), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTipoIncidencia/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (tipoIncidenciaService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
