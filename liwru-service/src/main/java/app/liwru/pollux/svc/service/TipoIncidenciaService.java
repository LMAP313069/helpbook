package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.TipoIncidencia;
import app.liwru.pollux.svc.repository.TipoIncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoIncidenciaService implements CrudService<TipoIncidencia, Integer> {

    private final TipoIncidenciaRepository tipoIncidenciaRepository;

    public TipoIncidenciaService(TipoIncidenciaRepository tipoIncidenciaRepository) {
        this.tipoIncidenciaRepository = tipoIncidenciaRepository;
    }


    @Override
    public Optional<TipoIncidencia> findById(Integer integer) {
        return tipoIncidenciaRepository.findById(integer);
    }

    @Override
    public Optional<List<TipoIncidencia>> findAll() {
        return Optional.of(tipoIncidenciaRepository.findAll());
    }

    @Override
    public TipoIncidencia saveOrUpdate(TipoIncidencia tipoIncidencia) {
        return tipoIncidenciaRepository.save(tipoIncidencia);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((tipoIncidencia->{
            tipoIncidenciaRepository.delete(tipoIncidencia);
            return true;
        })).orElse(false);
    }
}
