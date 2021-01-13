package br.com.lotoluck.lotoluck.repository;

import br.com.lotoluck.lotoluck.model.Apostador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
    Apostador findByEmail(String email);
}
