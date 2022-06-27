package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Documento;
import app.liwru.pollux.svc.service.DocumentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/documentos")
@RestController
public class DocumentoResource {

    private final DocumentoService documentoService;

    public DocumentoResource(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }


    @GetMapping
    public ResponseEntity<List<Documento>> getAll() {
        return documentoService.findAll()
                .map(documentos -> documentos.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(documentos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> getDocumento(@PathVariable int id) {
        return documentoService.findById(id)
                .map(documento -> new ResponseEntity<>(documento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByIdIncidencia/{id}")
    public ResponseEntity<List<Documento>> getByIdIncidencia(@PathVariable Integer id) {
        return documentoService.findByIdIncidencia(id)
                .map(documentos -> documentos.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(documentos, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<Documento> save(@RequestBody Documento documentos) {
        return new ResponseEntity<>(documentoService.saveOrUpdate(documentos), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Documento> update(@RequestBody Documento documentos) {
        return new ResponseEntity<>(documentoService.saveOrUpdate(documentos), HttpStatus.OK);
    }

    @DeleteMapping("/deleteDocumento/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (documentoService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
