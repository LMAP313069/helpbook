package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Documento;
import app.liwru.pollux.svc.model.Documento;
import app.liwru.pollux.svc.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService implements CrudService<Documento, Integer> {

    
    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }


    @Override
    public Optional<Documento> findById(Integer integer) {
        return documentoRepository.findById(integer);
    }

    @Override
    public Optional<List<Documento>> findAll() {
        return Optional.of(documentoRepository.findAll());
    }

    @Override
    public Documento saveOrUpdate(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((documento->{
            documentoRepository.delete(documento);
            return true;
        })).orElse(false);
    }

    public Optional<List<Documento>> findByIdIncidencia(Integer integer) {
        return (documentoRepository.findByIdIncidencia(integer));
    }

}
