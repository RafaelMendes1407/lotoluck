package br.com.lotoluck.lotoluck.controller.DTO;

import br.com.lotoluck.lotoluck.model.Aposta;
import br.com.lotoluck.lotoluck.model.Apostador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApostaDTO {


    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private ApostadorDTO apostador;
    private String numerosApostados;

    public static ApostaDTO converterAposta(Aposta aposta) {

        return new ApostaDTO(aposta.getId(), aposta.getDate(), ApostadorDTO.converterApostador(aposta.getApostador()), aposta.getNumerosApostados());
    }
}
