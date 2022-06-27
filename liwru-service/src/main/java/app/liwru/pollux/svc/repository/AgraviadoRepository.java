package app.liwru.pollux.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.liwru.pollux.svc.model.Agraviado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgraviadoRepository extends JpaRepository<Agraviado, Integer> {




    @Query(value = "SELECT * FROM Agraviado ORDER BY idAgraviado  DESC limit 1", nativeQuery = true)
    Optional<Agraviado> findLast();
}
