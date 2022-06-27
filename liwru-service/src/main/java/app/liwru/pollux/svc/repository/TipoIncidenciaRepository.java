package app.liwru.pollux.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.liwru.pollux.svc.model.TipoIncidencia;

@Repository
public interface TipoIncidenciaRepository extends JpaRepository<TipoIncidencia, Integer> {
}
