package br.com.lotoluck.lotoluck.services;

import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.repository.ApostaRepository;
import org.springframework.stereotype.Service;

@Service
public class ApostarService {

    public static Aposta realizarAposta(ApostaRepository apostaRepo, Apostador apostador){
        boolean apostar = true;
        String nums = "";
        Aposta aposta = new Aposta();
        aposta.setApostador(apostador);

        while(apostar){
            nums = NumerosDeAposta.apostar(60, 6);
            aposta.setNumerosApostados(nums);
            apostar = aposta.apostaNaoEhPossivel(apostaRepo);
        }

        return apostaRepo.save(aposta);

    }
}
