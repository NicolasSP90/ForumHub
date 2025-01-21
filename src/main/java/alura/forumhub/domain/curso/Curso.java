package alura.forumhub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaCurso categoriaCurso;

    public Curso(@Valid DadosCriarCurso dados) {
        this.nome = dados.nome();
        this.categoriaCurso = dados.categoriaCurso();
    }
}
