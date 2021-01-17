package br.com.lotoluck.lotoluck.repository;

import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.services.NumerosDeAposta;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;


@DataJpaTest
@RunWith(SpringRunner.class)
@DisplayName("Testes para Aposta Repository")
class ApostaRepositoryTest {

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private ApostadorRepository apostadorRepository;

    private Apostador apostador = new Apostador( "apostador@gmail.com", "Apostador1", "310.211.720-14");

    @BeforeEach
    public void criaUmApostador(){
        apostadorRepository.save(apostador);
    }

    @Test
    public void salvaApostaQuandoBemSucedido() {
        String nums = NumerosDeAposta.apostar(60, 6);
        Aposta aposta = new Aposta(apostador, nums);
        Aposta apostaSalva = this.apostaRepository.save(aposta);
        Assertions.assertThat(apostaSalva).isNotNull();
        Assertions.assertThat(apostaSalva.getApostador().getNome()).isEqualTo(aposta.getApostador().getNome());
        Assertions.assertThat(apostaSalva.getId()).isNotNull();
    }

    @Test
    public void naoDevePermitirDuasApostasIdenticasParaoMesmoApostador() {
        String numsPrimeiraAposta = "[4, 21, 45, 48, 50, 56]";
        String numsSegundaAposta = "[4, 21, 45, 48, 50, 56]";
        Aposta primeiraAposta = new Aposta(apostador, numsPrimeiraAposta);
        Aposta segundaAposta = new Aposta(apostador, numsSegundaAposta);

        Assertions.assertThat(primeiraAposta.getNumerosApostados()).isNotEqualTo(segundaAposta.getNumerosApostados());

    }


}