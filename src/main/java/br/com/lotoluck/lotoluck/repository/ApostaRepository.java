package br.com.lotoluck.lotoluck.repository;

import br.com.lotoluck.lotoluck.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {

    Optional<Aposta> findByNumerosApostados(String numerosApostados);

}
