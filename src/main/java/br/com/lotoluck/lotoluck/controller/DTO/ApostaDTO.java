package br.com.lotoluck.lotoluck.controller.DTO;

import br.com.lotoluck.lotoluck.model.Aposta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApostaDTO {


    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private String numerosApostados;

    public ApostaDTO(Aposta aposta){
        this.id = aposta.getId();
        this.date = aposta.getDate();
        this.numerosApostados = aposta.getNumerosApostados();
    }

    public static List<ApostaDTO> converter(List<Aposta> apostas){
        return apostas.stream().map(ApostaDTO::new).collect(Collectors.toList());
    }

    public static ApostaDTO converterAposta(Aposta aposta) {

        return new ApostaDTO(aposta.getId(), aposta.getDate(), aposta.getNumerosApostados());
    }
}
