package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Departamento;
import app.liwru.pollux.svc.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements CrudService<Departamento, Integer> {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Optional<Departamento> findById(Integer integer) {
        return departamentoRepository.findById(integer);
    }

    @Override
    public Optional<List<Departamento>> findAll() {
        return Optional.of(departamentoRepository.findAll());
    }

    @Override
    public Departamento saveOrUpdate(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((departamento->{
            departamentoRepository.delete(departamento);
            return true;
        })).orElse(false);
    }
}
