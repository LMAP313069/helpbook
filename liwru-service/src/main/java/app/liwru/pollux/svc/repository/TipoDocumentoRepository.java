package app.liwru.pollux.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.liwru.pollux.svc.model.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
