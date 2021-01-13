package br.com.lotoluck.lotoluck.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "apostador")
public class Apostador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    @Length(max = 150)
    @Column(unique = true)
    private String email;

    @NotBlank(message = "{name.not.blank}")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;

    @AssertFalse
    private Boolean validado;

    public Apostador(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

}
