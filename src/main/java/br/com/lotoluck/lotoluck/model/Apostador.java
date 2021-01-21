package br.com.lotoluck.lotoluck.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @Email(message = "{email.not.valid}")
    @NotBlank(message = "{email.not.blank}")
    @Size(max = 150)
    @Column(unique = true)
    private String email;

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    @CPF
    private String cpf;

    private Boolean emailValidado;

    private Boolean cpfValidado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "apostador")
    private List<Aposta> apostas;

    public Apostador(String email, String nome, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Apostador(Long id, String email, String nome, String cpf) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
    }
}
