package alura.forumhub.domain.topico;

import alura.forumhub.domain.curso.CategoriaCurso;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCriarTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        @JsonAlias("data_criacao") LocalDateTime dataCriacao,

        @NotNull
        @JsonAlias("status") StatusTopico status,

        @NotNull
        @JsonAlias("usuario") Long idUsuario,

        @NotNull
        @JsonAlias("categoria_curso") CategoriaCurso categoria ) {
}
