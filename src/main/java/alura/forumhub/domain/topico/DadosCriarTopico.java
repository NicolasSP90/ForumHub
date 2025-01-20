package alura.forumhub.domain.topico;

import alura.forumhub.domain.curso.Curso;
import alura.forumhub.domain.usuario.Usuario;
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
        StatusTopico status,

        @NotNull
        Usuario usuario,

        @NotNull
        Curso curso ) {
}
