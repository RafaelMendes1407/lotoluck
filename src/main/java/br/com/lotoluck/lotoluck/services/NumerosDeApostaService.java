package br.com.lotoluck.lotoluck.services;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class NumerosDeApostaService {

    List<Integer> numerosdeAposta = new ArrayList<>();

    public static String apostar(int numerosDisponiveisParaAposta, int numerosApostados){
        NumerosDeApostaService nums = new NumerosDeApostaService();
        nums.gerarAposta(numerosDisponiveisParaAposta, numerosApostados);
        return nums.numerosApostados();
    }


    public boolean addNumerosNaLista(int i) {
        if (i == 0 || numerosDuplicados(i)) {
            return false;
        }
        this.numerosdeAposta.add(i);
        return true;
    }

    public void gerarAposta(int numerosDisponiveisParaAposta, int numerosApostados) {
        Random random = new Random();

        while (this.numerosdeAposta.size() < numerosApostados) {
            int numero = random.nextInt(numerosDisponiveisParaAposta);
            addNumerosNaLista(numero);
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
