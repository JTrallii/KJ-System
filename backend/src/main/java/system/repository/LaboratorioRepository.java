package system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.domain.Laboratorio;

import java.util.List;
import java.util.Optional;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
    Optional<Laboratorio> findByNome(String nome);

    Optional<List<Laboratorio>> findAllByAtivoTrue();
}
