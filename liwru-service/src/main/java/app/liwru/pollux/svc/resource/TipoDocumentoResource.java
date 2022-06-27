package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.TipoDocumento;
import app.liwru.pollux.svc.service.TipoDocumentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tipos-documentos")
@RestController
public class TipoDocumentoResource {

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoResource(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> getAll() {
        return tipoDocumentoService.findAll()
                .map(tipoDocumentos -> tipoDocumentos.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(tipoDocumentos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumento(@PathVariable int id) {
        return tipoDocumentoService.findById(id)
                .map(tipoDocumento -> new ResponseEntity<>(tipoDocumento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> save(@RequestBody TipoDocumento tipoDocumentos) {
        return new ResponseEntity<>(tipoDocumentoService.saveOrUpdate(tipoDocumentos), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TipoDocumento> update(@RequestBody TipoDocumento tipoDocumentos) {
        return new ResponseEntity<>(tipoDocumentoService.saveOrUpdate(tipoDocumentos), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTipoDocumento/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (tipoDocumentoService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
