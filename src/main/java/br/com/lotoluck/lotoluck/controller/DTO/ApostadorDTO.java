package br.com.lotoluck.lotoluck.controller.DTO;

import br.com.lotoluck.lotoluck.model.Apostador;
import lombok.Data;


@Data
public class ApostadorDTO {
    private Long id;
    private String email;
    private String nome;

    public ApostadorDTO(Apostador apostador){
        this.id = apostador.getId();
        this.email = apostador.getEmail();
        this.nome = apostador.getNome();
    }

    public static ApostadorDTO converter(Apostador apostador){
        return new ApostadorDTO(apostador);
    }
}
