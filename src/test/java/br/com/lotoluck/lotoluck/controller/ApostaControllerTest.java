package br.com.lotoluck.lotoluck.controller;

import br.com.lotoluck.lotoluck.controller.form.ApostaForm;
import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.repository.ApostaRepository;
import br.com.lotoluck.lotoluck.repository.ApostadorRepository;
import br.com.lotoluck.lotoluck.services.NumerosDeApostaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.http.ContentType;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = ApostaController.class)
@RunWith(SpringRunner.class)
public class ApostaControllerTest {

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private ApostadorRepository apostadorRepository;

    private Apostador apostador = new Apostador("apostador@gmail.com", "Apostador1", "310.211.720-14");

    @BeforeEach
    public void criaUmApostador() {
        apostadorRepository.save(apostador);
    }
    private String port = "8080";

    @Test
    public void deveCriarUmanovaAposta() {

        when(this.apostadorRepository.findByEmail("email@email.com"))
                .thenReturn(Optional.of(new Apostador(1L, "email@email.com", "Apostador 1", "406.018.200-10")));

        Aposta aposta = new Aposta();
        when(this.apostaRepository.save(aposta)).thenReturn(new Aposta(1L, apostador, NumerosDeApostaService.apostar(60, 6)));

        ApostaForm apostaForm = new ApostaForm("email@email.com");

        given().request().header("Accept", ContentType.ANY).header("Content-type", ContentType.JSON)
                .body(apostaForm)
                .when()
                .post("/apostas")
                .then().log().headers()
                .and().log().body()
                .and()
                .statusCode(HttpStatus.CREATED.value())
                .headers("Location", equalTo("http://localhost:"+port+"/apostas/1"))
                .body("codigo", equalTo(6));


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
