package br.com.lotoluck.lotoluck.controller;

import br.com.lotoluck.lotoluck.controller.DTO.ApostaDTO;
import br.com.lotoluck.lotoluck.controller.form.ApostaForm;
import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.repository.ApostaRepository;
import br.com.lotoluck.lotoluck.repository.ApostadorRepository;
import br.com.lotoluck.lotoluck.services.ApostarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if (apostador.isEmpty()) {return ResponseEntity.notFound().build();}
        Aposta aposta = ApostarService.realizarAposta(apostaRepo, apostador.get());
        return new ResponseEntity<ApostaDTO>(ApostaDTO.converterAposta(aposta), HttpStatus.CREATED);
    }
}
