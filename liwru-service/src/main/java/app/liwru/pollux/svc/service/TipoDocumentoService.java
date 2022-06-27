package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.TipoDocumento;
import app.liwru.pollux.svc.repository.TipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoService implements CrudService<TipoDocumento, Integer> {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }


    @Override
    public Optional<TipoDocumento> findById(Integer integer) {
        return tipoDocumentoRepository.findById(integer);
    }

    @Override
    public Optional<List<TipoDocumento>> findAll() {
        return Optional.of(tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumento saveOrUpdate(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((tipoDocumento->{
            tipoDocumentoRepository.delete(tipoDocumento);
            return true;
        })).orElse(false);
    }
}
