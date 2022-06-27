package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Distrito;
import app.liwru.pollux.svc.repository.DistritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoService implements CrudService<Distrito, Integer> {

    private final DistritoRepository distritoRepository;

    public DistritoService(DistritoRepository distritoRepository) {
        this.distritoRepository = distritoRepository;
    }


    @Override
    public Optional<Distrito> findById(Integer integer) {
        return distritoRepository.findById(integer);
    }

    @Override
    public Optional<List<Distrito>> findAll() {
        return Optional.of(distritoRepository.findAll());
    }

    @Override
    public Distrito saveOrUpdate(Distrito distrito) {
        return distritoRepository.save(distrito);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((distrito->{
            distritoRepository.delete(distrito);
            return true;
        })).orElse(false);
    }
}
