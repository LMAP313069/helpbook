package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Incidencia;
import app.liwru.pollux.svc.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService implements CrudService<Incidencia, Integer> {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    @Override
    public Optional<Incidencia> findById(Integer integer) {
        return incidenciaRepository.findById(integer);
    }



    @Override
    public Optional<List<Incidencia>> findAll() {
        return Optional.of(incidenciaRepository.findAll());
    }

    @Override
    public Incidencia saveOrUpdate(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((incidencia->{
            incidenciaRepository.delete(incidencia);
            return true;
        })).orElse(false);
    }


    public Optional<List<Incidencia>> findByIdAgraviado(Integer integer) {
        return  incidenciaRepository.findByIdAgraviado(integer);
    }

    public Optional<Incidencia> findByCodigoIncidencia(String icodigoIncidencia) {
        return incidenciaRepository.findByCodigoIncidencia(icodigoIncidencia);
    }



}
