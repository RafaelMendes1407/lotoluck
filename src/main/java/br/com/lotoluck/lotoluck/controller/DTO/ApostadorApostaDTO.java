package br.com.lotoluck.lotoluck.controller.DTO;

import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApostadorApostaDTO {
    private Long id;
    private String email;
    private String nome;
    private List<ApostaDTO> apostas;

    public static ApostadorApostaDTO converter(Apostador apostador) {
        return new ApostadorApostaDTO(apostador.getId(),
                apostador.getEmail(),
                apostador.getNome(),
                ApostaDTO.converter(apostador.getApostas())
        );
    }
}
