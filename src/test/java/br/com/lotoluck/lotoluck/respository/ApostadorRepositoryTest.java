package br.com.lotoluck.lotoluck.respository;

import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.repository.ApostadorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApostadorRepositoryTest {

    @Autowired
    private ApostadorRepository repository;

    @Test
    public void deveCriarUmApostador() {
        String email = "email@email.com";
        Apostador apostador = new Apostador();
        apostador.setEmail(email);
        repository.save(apostador);
        System.out.println(apostador.getEmail());
    }
}
