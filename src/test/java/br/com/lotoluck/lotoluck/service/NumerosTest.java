package br.com.lotoluck.lotoluck.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.lotoluck.lotoluck.services.NumerosDeAposta;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NumerosTest {

    @Test
    @DisplayName("╯°□°）╯")
    public void DeveGerarListaDeNumerosParaAposta() {
        NumerosDeAposta numeros = new NumerosDeAposta();
        numeros.gerarAposta(60, 6);
        assertEquals(6, numeros.qtdnumApostados());
    }

    @Test
    public void NaoDeveAceitarValorZero(){
        NumerosDeAposta num = new NumerosDeAposta();
        num.add(0);
        assertEquals(0, num.qtdnumApostados());
    }

    @Test
    public void NaoDeveAceitarNumerosRepetidos(){
        NumerosDeAposta num = new NumerosDeAposta();
        num.add(20);
        num.add(20);
        assertEquals(1, num.qtdnumApostados());
    }

    @Test
    public void deveGerarQuantidadeDeNumerosSemRepeticao(){
        NumerosDeAposta num = new NumerosDeAposta();
        num.gerarAposta(10, 6);
        assertEquals(6, num.qtdnumApostados());
    }

    @Test
    public void deveRetornarOsNumerosSorteadosEmOrdemCrescente(){
        NumerosDeAposta num = new NumerosDeAposta();
        num.add(14);
        num.add(58);
        num.add(33);
        num.add(23);
        num.add(6);
        num.add(11);
        assertEquals("[6, 11, 14, 23, 33, 58]", num.numerosApostados());

    }

    @Test
    @DisplayName("╯°□°）╯")
    public void deveGerarApostaPeloMetodoEstatico(){
        String num = NumerosDeAposta.apostar(6,3);
        assertTrue(num.length() > 6);
    }
}
