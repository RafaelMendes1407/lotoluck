package br.com.lotoluck.lotoluck.model;

import br.com.lotoluck.lotoluck.repository.ApostaRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@Entity
@Table(name = "apostas")
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED) private Long id;

    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name="apostador_id", referencedColumnName="id", nullable=false)
    private Apostador apostador;

    @NotBlank
    private String numerosApostados;

    public Aposta(Apostador apostador, String nums) {
        this.numerosApostados = nums;
        this.date = LocalDateTime.now();
        this.apostador = apostador;
    }

    public Aposta(Long id, Apostador apostador, String nums) {
        this.id = id;
        this.numerosApostados = nums;
        this.date = LocalDateTime.now();
        this.apostador = apostador;
    }
}
