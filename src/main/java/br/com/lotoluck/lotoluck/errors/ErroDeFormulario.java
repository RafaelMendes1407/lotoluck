package br.com.lotoluck.lotoluck.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDeFormulario {
    private String campo;
    private String erro;
}