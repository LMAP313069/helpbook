package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Rol;
import app.liwru.pollux.svc.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements CrudService<Rol, Integer> {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }


    @Override
    public Optional<Rol> findById(Integer integer) {
        return rolRepository.findById(integer);
    }

    @Override
    public Optional<List<Rol>> findAll() {
        return Optional.of(rolRepository.findAll());
    }

    @Override
    public Rol saveOrUpdate(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((rol->{
            rolRepository.delete(rol);
            return true;
        })).orElse(false);
    }
}
