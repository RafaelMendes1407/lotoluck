package br.com.lotoluck.lotoluck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.lotoluck.lotoluck.model.NumerosDeAposta;
import org.junit.Test;

public class NumerosTest {

    @Test
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


}
