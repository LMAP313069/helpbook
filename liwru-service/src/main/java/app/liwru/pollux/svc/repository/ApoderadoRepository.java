package app.liwru.pollux.svc.repository;

import app.liwru.pollux.svc.model.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoderadoRepository extends JpaRepository<Apoderado, Integer> {
}
