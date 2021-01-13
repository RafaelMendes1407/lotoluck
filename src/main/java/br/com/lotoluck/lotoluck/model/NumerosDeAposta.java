package br.com.lotoluck.lotoluck.model;

import lombok.Data;

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

    public void gerarAposta(int numerosDisponiveisParaAposta, int numerosApostados) {
        Random random = new Random();
        int numero;

        while (this.numerosdeAposta.size() < numerosApostados) {
            numero = random.nextInt(numerosDisponiveisParaAposta);
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

    public String numerosApostados() {
        this.numerosdeAposta.sort(Integer::compareTo);

        return this.numerosdeAposta.toString();
    }
}


