package br.com.lotoluck.lotoluck.controller.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApostaForm {

    @Email(message = "{email.not.valid}")
    private String email;
}
