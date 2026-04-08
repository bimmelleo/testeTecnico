package testeTecnico.bombacomb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaCombRepository extends JpaRepository<BombaComb, Long> {

    boolean existsByTipoCombId(Long tipoId);

}