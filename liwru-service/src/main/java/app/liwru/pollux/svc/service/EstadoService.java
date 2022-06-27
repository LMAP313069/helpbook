package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Estado;
import app.liwru.pollux.svc.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService implements CrudService<Estado, Integer> {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }


    @Override
    public Optional<Estado> findById(Integer integer) {
        return estadoRepository.findById(integer);
    }

    @Override
    public Optional<List<Estado>> findAll() {
        return Optional.of(estadoRepository.findAll());
    }

    @Override
    public Estado saveOrUpdate(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((estado->{
            estadoRepository.delete(estado);
            return true;
        })).orElse(false);
    }



}
