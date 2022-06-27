package app.liwru.pollux.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.liwru.pollux.svc.model.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
}
