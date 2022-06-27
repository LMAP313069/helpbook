package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Provincia;
import app.liwru.pollux.svc.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService implements CrudService<Provincia, Integer> {

    private final ProvinciaRepository provinciaRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }


    @Override
    public Optional<Provincia> findById(Integer integer) {
        return provinciaRepository.findById(integer);
    }

    @Override
    public Optional<List<Provincia>> findAll() {
        return Optional.of(provinciaRepository.findAll());
    }

    @Override
    public Provincia saveOrUpdate(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((provincia->{
            provinciaRepository.delete(provincia);
            return true;
        })).orElse(false);
    }
}
