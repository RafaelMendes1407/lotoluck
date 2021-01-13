package br.com.lotoluck.lotoluck.controller;

import br.com.lotoluck.lotoluck.controller.DTO.ApostadorDTO;
import br.com.lotoluck.lotoluck.controller.form.ApostadorForm;
import br.com.lotoluck.lotoluck.model.Apostador;
import br.com.lotoluck.lotoluck.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/apostador")
public class ApostadorController {

    @Autowired
    ApostadorRepository repository;


    @PostMapping
    public ResponseEntity<ApostadorDTO> cadastrarApostador (@RequestBody @Valid ApostadorForm form){
        Apostador apostador = form.converter();
        repository.save(apostador);
        return new ResponseEntity<>(new ApostadorDTO(apostador), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApostadorDTO> obterApostas(@PathVariable Long id){

    }
}
