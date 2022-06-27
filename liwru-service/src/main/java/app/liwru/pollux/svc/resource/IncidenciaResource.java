package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Incidencia;
import app.liwru.pollux.svc.model.Incidencia;
import app.liwru.pollux.svc.model.Usuario;
import app.liwru.pollux.svc.service.IncidenciaService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/incidencias")
@RestController
public class IncidenciaResource {

    private final IncidenciaService incidenciaService;

    public IncidenciaResource(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Incidencia>> getAll() {
        return incidenciaService.findAll()
                .map(incidencias -> incidencias.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(incidencias, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> getIncidencia(@PathVariable int id) {
        return incidenciaService.findById(id)
                .map(incidencia -> new ResponseEntity<>(incidencia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Incidencia> save(@RequestBody Incidencia incidencias) {
        return new ResponseEntity<>(incidenciaService.saveOrUpdate(incidencias), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Incidencia incidencias) {
        Optional<Incidencia> id = incidenciaService.findById(incidencias.getIdIncidencia());
        id.get().setIdEstado(incidencias.getIdEstado());
        id.get().setIdUsuario(incidencias.getIdUsuario());
        id.get().setJustificacionIncidencia(incidencias.getJustificacionIncidencia());
        id.get().setActualizadoPor(incidencias.getActualizadoPor());


        incidenciaService.saveOrUpdate(id.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteIncidencia/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (incidenciaService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }





/*    @PostMapping("/estadoPorResponsable")
    public ResponseEntity<Usuario> save(@RequestBody Usuario user) {
        return new ResponseEntity<>(usuarioService.saveOrUpdate(user), HttpStatus.CREATED);
    }*/

    @GetMapping("/getPorAgraviado/{id}")
    public ResponseEntity<List<Incidencia>> getIncidenciaPorAgraviado(@PathVariable Integer id) {
        return incidenciaService.findByIdAgraviado(id)
                .map(incidencia -> new ResponseEntity<>(incidencia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getPorCodigoIncidencia/{codigoIncidencia}")
    public ResponseEntity<Incidencia> getIncidenciaPorCodigoIncidencia(@PathVariable String codigoIncidencia) {
        return incidenciaService.findByCodigoIncidencia(codigoIncidencia)
                .map(incidencia -> new ResponseEntity<>(incidencia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
