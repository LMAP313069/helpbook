package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Apoderado;
import app.liwru.pollux.svc.repository.ApoderadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoService implements CrudService<Apoderado, Integer> {

    private ApoderadoRepository apoderadoRepository;

    public ApoderadoService(ApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }


    @Override
    public Optional<Apoderado> findById(Integer integer) {
        return apoderadoRepository.findById(integer);
    }

    @Override
    public Optional<List<Apoderado>> findAll() {
        return Optional.of(apoderadoRepository.findAll());
    }

    @Override
    public Apoderado saveOrUpdate(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((apoderado->{
            apoderadoRepository.delete(apoderado);
            return true;
        })).orElse(false);
    }
}
