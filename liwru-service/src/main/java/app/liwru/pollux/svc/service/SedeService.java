package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Sede;
import app.liwru.pollux.svc.repository.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService implements CrudService<Sede, Integer> {

    private final SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }


    @Override
    public Optional<Sede> findById(Integer integer) {
        return sedeRepository.findById(integer);
    }

    @Override
    public Optional<List<Sede>> findAll() {
        return Optional.of(sedeRepository.findAll());
    }

    @Override
    public Sede saveOrUpdate(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((sede->{
            sedeRepository.delete(sede);
            return true;
        })).orElse(false);
    }

    public boolean logicDelete(Integer integer) {
        return findById(integer)
                .map(sede -> {
                    sede.setEstado(0);
                    saveOrUpdate(sede);
                    return true;
                }).orElse(false);
    }

    public boolean logicActive(Integer integer) {
        return findById(integer)
                .map(sede -> {
                    sede.setEstado(1);
                    saveOrUpdate(sede);
                    return true;
                }).orElse(false);
    }

}
