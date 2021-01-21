package br.com.lotoluck.lotoluck.controller;

import br.com.lotoluck.lotoluck.controller.DTO.ApostaDTO;
import br.com.lotoluck.lotoluck.controller.form.ApostaForm;
import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.services.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/aposta")
public class ApostaController {

    @Autowired
    ApostaService apostaService;

    @PostMapping
    public ResponseEntity<ApostaDTO> novaAposta(@RequestBody @Valid ApostaForm apostaForm) {
        Aposta aposta = apostaService.realizarAposta(apostaForm.getEmail());
        return new ResponseEntity<ApostaDTO>(ApostaDTO.converterAposta(aposta), HttpStatus.CREATED);
    }
}
