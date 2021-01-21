package br.com.lotoluck.lotoluck.repository;

import br.com.lotoluck.lotoluck.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {

    Optional<Aposta> findByNumerosApostados(String numerosApostados);

    @Query(value = "select id from aposta  where id=:id and numeros_apostados=:numerosApostados ;", nativeQuery = true)
    Optional<Long> findByIdENumerosApostados(@Param("id") Long id,
                                               @Param("numerosApostados") String numerosApostados);
}
