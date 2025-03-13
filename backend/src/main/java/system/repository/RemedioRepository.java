package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.domain.Remedio;

import java.util.List;
import java.util.Optional;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    Optional<List<Remedio>> findAllByAtivoTrue();
}
