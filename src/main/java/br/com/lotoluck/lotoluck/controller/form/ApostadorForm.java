package br.com.lotoluck.lotoluck.controller.form;

import br.com.lotoluck.lotoluck.model.Apostador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApostadorForm {

    @Email
    private String email;
    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @CPF
    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;

    public Apostador converter() {
        return new Apostador(this.email, this.nome, this.cpf);
    }
}
