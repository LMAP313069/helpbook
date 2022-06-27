package app.liwru.pollux.svc.repository;

import app.liwru.pollux.svc.model.Documento;
import app.liwru.pollux.svc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    Optional<List<Documento>> findByIdIncidencia(Integer idIncidencia);

}
