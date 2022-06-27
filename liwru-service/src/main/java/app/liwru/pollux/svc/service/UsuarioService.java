package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Incidencia;
import app.liwru.pollux.svc.model.Rol;
import app.liwru.pollux.svc.model.Usuario;
import app.liwru.pollux.svc.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements CrudService<Usuario, Integer> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Optional<Usuario> findById(Integer integer) {
        return usuarioRepository.findById(integer);
    }

    @Override
    public Optional<List<Usuario>> findAll() {
        return Optional.of(usuarioRepository.findAll());
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((usuario->{
            usuarioRepository.delete(usuario);
            return true;
        })).orElse(false);
    }

    public boolean logicDelete(Integer integer) {
        return findById(integer)
                .map(usuario -> {
                    usuario.setEstado(0);
                    saveOrUpdate(usuario);
                    return true;
                }).orElse(false);
        }

    public boolean logicActive(Integer integer) {
        return findById(integer)
                .map(usuario -> {
                    usuario.setEstado(1);
                    saveOrUpdate(usuario);
                    return true;
                }).orElse(false);
    }



    public Optional<List<Usuario>> findByRols(Integer id) {
        return Optional.of(usuarioRepository.findByIdRolUsuario(id));
    }


    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmailUsuario(email);
    }


}

