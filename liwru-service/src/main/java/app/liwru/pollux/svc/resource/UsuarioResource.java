package app.liwru.pollux.svc.resource;

import app.liwru.pollux.svc.model.Incidencia;
import app.liwru.pollux.svc.model.Rol;
import app.liwru.pollux.svc.model.Usuario;
import app.liwru.pollux.svc.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/usuarios")
@RestController
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return usuarioService.findAll()
                .map(usuarios -> usuarios.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(usuarios, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
        return usuarioService.findById(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/email/{correo}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String correo) {
        return usuarioService.findByEmail(correo)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario user) {
        return new ResponseEntity<>(usuarioService.saveOrUpdate(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario user) {
        Optional<Usuario> id = usuarioService.findById(user.getIdUsuario());
        id.get().setNombreUsuario(user.getNombreUsuario());
        id.get().setApellidoUsuario(user.getApellidoUsuario());
        id.get().setEmailUsuario(user.getEmailUsuario());
        id.get().setIdTipoDoc(user.getIdTipoDoc());
        id.get().setNumeroDocUsuario(user.getNumeroDocUsuario());
        id.get().setIdRolUsuario(user.getIdRolUsuario());
        usuarioService.saveOrUpdate( id.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    


    @PutMapping("/deleteUsuario/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {

        if (usuarioService.logicDelete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/activeUsuario/{id}")
    public ResponseEntity active(@PathVariable int id) {

        if (usuarioService.logicActive(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("usuarioPorRol/{RolId}")
    public ResponseEntity<List<Usuario>> getUsuarioPorRol(@PathVariable Integer RolId) {
        return usuarioService.findByRols(RolId)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
