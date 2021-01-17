package br.com.lotoluck.lotoluck.errors;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroDeFormulario {
    private String campo;
    private String msg;
}