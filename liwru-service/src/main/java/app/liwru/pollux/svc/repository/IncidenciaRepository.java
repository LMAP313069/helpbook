package app.liwru.pollux.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.liwru.pollux.svc.model.Incidencia;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
    Optional<List< Incidencia>> findByIdAgraviado (Integer codigoAgraviado);
    Optional <Incidencia> findByCodigoIncidencia(String codigoIncidencia);
}
