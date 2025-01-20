package alura.forumhub.domain.curso;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DadosCriarCurso(
        @NotBlank
        String nome,

        @NotBlank
        @JsonAlias("categoria") CategoriaCurso categoriaCurso
) {
}
