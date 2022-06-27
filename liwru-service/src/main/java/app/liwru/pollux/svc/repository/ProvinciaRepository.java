package app.liwru.pollux.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.liwru.pollux.svc.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
}
