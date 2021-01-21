package br.com.lotoluck.lotoluck.service;

import br.com.lotoluck.lotoluck.services.ApostaService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ApostaServiceTest {

    @Test
    public void deveGerarApostaRespeitandoAQuantidadeDefinida() {
        ApostaService service = new ApostaService();
        List<Integer> numerosGerados = service.gerarNumerosAleatorios();
        Assert.assertEquals(numerosGerados.size(), 6);
    }

    @Test
    public void deveGerarApostaSemNumerosRepetidos() {
        ApostaService service = new ApostaService();
        List<Integer> numerosGerados = service.gerarNumerosAleatorios();
        Assert.assertEquals(new HashSet<>(numerosGerados).size(), 6);
    }

    @Test
    public void naoDeveGerarQuantidadeDeNumerosMaiorQueOMaximoPermitido() {
        ApostaService service = new ApostaService();
        List<Integer> numerosGerados = service.gerarNumerosAleatorios();
        Assert.assertEquals(new HashSet<>(numerosGerados).size(), 6);
    }

    @Test
    public void naoDeveGerarNumeroMaiorQueSessenta(){
        ApostaService service = new ApostaService();
        List<Integer> numerosGerados = service.gerarNumerosAleatorios();
        List<Integer> numerosGeradosMaioresQueOPermitido = numerosGerados.stream()
                .filter(val -> val > 60)
                .collect(Collectors.toList());
        Assert.assertEquals(new HashSet<>(numerosGeradosMaioresQueOPermitido).size(), 0);
    }

    @Test
    public void naoDeveGerarNumeroZero() {
        ApostaService service = new ApostaService();
        List<Integer> numerosGerados = service.gerarNumerosAleatorios();
        List<Integer> numerosGeradosMaioresQueOPermitido = numerosGerados.stream()
                .filter(val -> val == 0)
                .collect(Collectors.toList());
        Assert.assertEquals(new HashSet<>(numerosGeradosMaioresQueOPermitido).size(), 0);
    }
}
