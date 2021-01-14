package br.com.lotoluck.lotoluck.controller;

import br.com.lotoluck.lotoluck.controller.DTO.ApostaDTO;
import br.com.lotoluck.lotoluck.controller.form.ApostaForm;
import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.model.NumerosDeAposta;
import br.com.lotoluck.lotoluck.repository.ApostaRepository;
import br.com.lotoluck.lotoluck.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/apostas")
public class ApostaController {

    @Autowired
    ApostadorRepository apostadorRepo;

    @Autowired
    ApostaRepository apostaRepo;

    @PostMapping
    public ResponseEntity<ApostaDTO> novaAposta(@RequestBody @Valid ApostaForm email) {
        Optional<Apostador> apostador = apostadorRepo.findByEmail(email.getEmail());

        if (apostador.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        NumerosDeAposta nums = new NumerosDeAposta();
        nums.gerarAposta(60, 6);
        Aposta aposta = new Aposta();
        aposta.setApostador(apostador.get());
        aposta.setNumerosApostados(nums.numerosApostados());
        apostaRepo.save(aposta);
        return new ResponseEntity<ApostaDTO>(ApostaDTO.converterAposta(aposta), HttpStatus.CREATED);
    }
}
