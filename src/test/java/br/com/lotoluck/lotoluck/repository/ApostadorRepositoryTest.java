package br.com.lotoluck.lotoluck.repository;

import br.com.lotoluck.lotoluck.model.Apostador;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@DataJpaTest
@DisplayName("Testes para Apostador Respository")
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
class ApostadorRepositoryTest {

    @Autowired
    ApostadorRepository apostadorRepository;

    @Test
    public void deveGravarUmNovoApostadorQuandoTodosOSDadosEstaoCorretos(){
        Apostador apostador = new Apostador("email@email.com", "Nome Teste 1", "310.211.720-14");
        Apostador apostadorSalvo = this.apostadorRepository.save(apostador);

        Assertions.assertThat(apostadorSalvo).isNotNull();
        Assertions.assertThat(apostadorSalvo.getCpf()).isNotNull();
        Assertions.assertThat(apostadorSalvo.getNome()).isEqualTo(apostador.getNome());
    }

    @Test
    public void deveBuscarUmApostadorPorEmail(){
        Optional<Apostador> apostador = this.apostadorRepository.findByEmail("email@email.com");
        Assertions.assertThat(apostador.isPresent());
    }


    @Test
    public void naoDeveSerPossivelAdicionarUmApostadorComAlgumEmailJaInformado(){
        Assertions.assertThatThrownBy(()->{
            Apostador apostador = new Apostador("email@email.com", "Nome Teste 1", "310.211.720-14");
            Apostador apostadorSalvo = this.apostadorRepository.save(apostador);
            Apostador apostador2 = new Apostador("email@email.com", "Nome Teste 1", "310.211.720-14");
            Apostador apostadorSalvo2 = this.apostadorRepository.save(apostador2);
        }).isInstanceOf(DataIntegrityViolationException.class);
    }

}