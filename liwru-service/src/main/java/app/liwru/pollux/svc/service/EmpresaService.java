package app.liwru.pollux.svc.service;

import app.liwru.pollux.svc.model.Empresa;
import app.liwru.pollux.svc.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements CrudService<Empresa, Integer> {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    @Override
    public Optional<Empresa> findById(Integer integer) {
        return  empresaRepository.findById(integer);
    }

    @Override
    public Optional<List<Empresa>> findAll() {
        return Optional.of(empresaRepository.findAll());
    }

    @Override
    public Empresa saveOrUpdate(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public boolean deleteById(Integer integer) {
        return findById(integer).map((empresa->{
            empresaRepository.delete(empresa);
            return true;
        })).orElse(false);
    }
}
