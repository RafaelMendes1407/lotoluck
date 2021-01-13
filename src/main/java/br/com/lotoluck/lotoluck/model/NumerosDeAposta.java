package br.com.lotoluck.lotoluck.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class NumerosDeAposta {
    List<Integer> numerosdeAposta = new ArrayList<>();


    public boolean add(int i) {
        if (i == 0 || numerosDuplicados(i)) {
            return false;
        }
        this.numerosdeAposta.add(i);
        return true;
    }

    public void gerarAposta(int numerosDisponiveis, int numerosApostados) {
        Random random = new Random();
        int numero = 0;
        for (int i = 0; i < numerosApostados; i++) {
            numero = random.nextInt(numerosDisponiveis);
            add(numero);
        }
    }

    public int qtdnumApostados() {
        return this.numerosdeAposta.size();
    }

    public boolean numerosDuplicados(int i) {
        if (this.numerosdeAposta.size() > 0) {
            return this.numerosdeAposta.contains(i);
        }
        return false;
    }
}


