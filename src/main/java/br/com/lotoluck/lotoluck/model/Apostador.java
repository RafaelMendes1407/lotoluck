package br.com.lotoluck.lotoluck.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apostador")
public class Apostador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Email
    @Size(max = 150)
    @Column(unique = true)
    private String email;

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    @CPF
    private String cpf;

    @AssertFalse
    private Boolean validado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "apostador")
    private List<Aposta> apostas;

    public Apostador(String email, String nome, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

}
