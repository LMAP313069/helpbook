package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Motivo;
import app.liwru.pollux.svc.repository.MotivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotivoService implements CrudService<Motivo, Integer> {

    private final MotivoRepository motivoRepository;

    public MotivoService(MotivoRepository motivoRepository) {
        this.motivoRepository = motivoRepository;
    }


    @Override
    public Optional<Motivo> findById(Integer integer) {
        return motivoRepository.findById(integer);
    }

    @Override
    public Optional<List<Motivo>> findAll() {
        return Optional.of(motivoRepository.findAll());
    }

    @Override
    public Motivo saveOrUpdate(Motivo motivo) {
        return motivoRepository.save(motivo);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((motivo->{
            motivoRepository.delete(motivo);
            return true;
        })).orElse(false);
    }

    public boolean logicDelete(Integer integer) {
        return findById(integer)
                .map(motivo -> {
                    motivo.setEstadoMotivo(0);
                    saveOrUpdate(motivo);
                    return true;
                }).orElse(false);
    }

    public boolean logicActive(Integer integer) {
        return findById(integer)
                .map(motivo -> {
                    motivo.setEstadoMotivo(1);
                    saveOrUpdate(motivo);
                    return true;
                }).orElse(false);
    }
}
