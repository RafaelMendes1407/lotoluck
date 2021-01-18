package br.com.lotoluck.lotoluck.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.lotoluck.lotoluck.services.NumerosDeApostaService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NumerosTest {

    @Test
    @DisplayName("╯°□°）╯")
    public void DeveGerarListaDeNumerosParaAposta() {
        NumerosDeApostaService numeros = new NumerosDeApostaService();
        numeros.gerarAposta(60, 6);
        assertEquals(6, numeros.qtdnumApostados());
    }

    @Test
    public void NaoDeveAceitarValorZero(){
        NumerosDeApostaService num = new NumerosDeApostaService();
        num.addNumerosNaLista(0);
        assertEquals(0, num.qtdnumApostados());
    }

    @Test
    public void NaoDeveAceitarNumerosRepetidos(){
        NumerosDeApostaService num = new NumerosDeApostaService();
        num.addNumerosNaLista(20);
        num.addNumerosNaLista(20);
        assertEquals(1, num.qtdnumApostados());
    }

    @Test
    public void deveGerarQuantidadeDeNumerosSemRepeticao(){
        NumerosDeApostaService num = new NumerosDeApostaService();
        num.gerarAposta(10, 6);
        assertEquals(6, num.qtdnumApostados());
    }

    @Test
    public void deveRetornarOsNumerosSorteadosEmOrdemCrescente(){
        NumerosDeApostaService num = new NumerosDeApostaService();
        num.addNumerosNaLista(14);
        num.addNumerosNaLista(58);
        num.addNumerosNaLista(33);
        num.addNumerosNaLista(23);
        num.addNumerosNaLista(6);
        num.addNumerosNaLista(11);
        assertEquals("[6, 11, 14, 23, 33, 58]", num.numerosApostados());

    }

    @Test
    @DisplayName("╯°□°）╯")
    public void deveGerarApostaPeloMetodoEstatico(){
        String num = NumerosDeApostaService.apostar(6,3);
        assertTrue(num.length() > 6);
    }
}
