package br.com.lotoluck.lotoluck.services;

import br.com.lotoluck.lotoluck.errors.ApostadorNaoEncontradoException;
import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.repository.ApostaRepository;
import br.com.lotoluck.lotoluck.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ApostaService {
    @Autowired
    ApostadorRepository apostadorRepo;

    private Integer valorMaximo = 60;

    private Integer quantidadeDeNumerosAposta = 6;

    @Autowired
    ApostaRepository apostaRepo;

    public Aposta realizarAposta(String email) {
        Optional<Apostador> apostador = encontrarApostadorPorEmail(email);
        if (apostador.isEmpty()) {
            throw new ApostadorNaoEncontradoException("Não existe apostador já cadastrado com esse email, não é " +
                    "possível criar a aposta");
        }
        Aposta aposta = new Aposta();
        aposta.setNumerosApostados(gerarNumerosAleatoriosNaorepetidosParaOMesmoEmail(apostador.get()));
        aposta.setApostador(apostador.get());
        apostaRepo.save(aposta);
        return aposta;
    }

    public boolean apostaJaFoiGeradaParaEsseApostador(Long id, String numerosApostados) {
        Optional<Long> registro = apostaRepo.findByIdENumerosApostados(id, numerosApostados);
        return registro.isPresent();
    }

    private Optional<Apostador> encontrarApostadorPorEmail(String email) {
        return apostadorRepo.findByEmail(email);
    }

    public List<Integer> gerarNumerosAleatorios() {
        List<Integer> numerosGerados = new ArrayList<>();
        ThreadLocalRandom.current().ints(1, valorMaximo).distinct().limit(quantidadeDeNumerosAposta).sorted()
                .forEach(numerosGerados::add);
        return numerosGerados;
    }

    public String gerarNumerosAleatoriosNaorepetidosParaOMesmoEmail(Apostador apostador) {
        List<Integer> numerosGerados = gerarNumerosAleatorios();
        String numerosGeradosStr = numerosGerados.toString();
        if (apostaJaFoiGeradaParaEsseApostador(apostador.getId(), numerosGeradosStr)) {
            gerarNumerosAleatorios();
        }
        return numerosGeradosStr;
    }
}
