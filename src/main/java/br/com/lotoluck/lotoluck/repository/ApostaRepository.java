package br.com.lotoluck.lotoluck.repository;

import br.com.lotoluck.lotoluck.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {
}
