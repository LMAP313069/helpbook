package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.repository.AgraviadoRepository;
import org.springframework.stereotype.Service;
import app.liwru.pollux.svc.model.Agraviado;

import java.util.List;
import java.util.Optional;

@Service
public class AgraviadoService implements CrudService<Agraviado, Integer> {

    private final AgraviadoRepository agraviadoRepository;

    public AgraviadoService(AgraviadoRepository agraviadoRepository) {
        this.agraviadoRepository = agraviadoRepository;
    }


    @Override
    public Optional<Agraviado> findById(Integer integer) {
        return agraviadoRepository.findById(integer);
    }

    @Override
    public Optional<List<Agraviado>> findAll() {
        return Optional.of(agraviadoRepository.findAll());
    }

    @Override
    public Agraviado saveOrUpdate(Agraviado agraviado) {
        return agraviadoRepository.save(agraviado);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((agraviado->{
            agraviadoRepository.delete(agraviado);
            return true;
        })).orElse(false);
    }

    public boolean logicDelete(Integer integer) {
        return findById(integer)
                .map(agraviado -> {
                    agraviado.setEstado(0);
                    return true;
                }).orElse(false);
    }


    public Optional<Agraviado> findLast() {
        return agraviadoRepository.findLast();
    }

}
