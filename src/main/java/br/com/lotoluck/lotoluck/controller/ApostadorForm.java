package br.com.lotoluck.lotoluck.controller;

import br.com.lotoluck.lotoluck.model.Apostador;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ApostadorForm {
    @NotBlank
    private String email;
    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    public Apostador converter() {
        return new Apostador(this.email, this.nome, this.cpf);
    }
}
