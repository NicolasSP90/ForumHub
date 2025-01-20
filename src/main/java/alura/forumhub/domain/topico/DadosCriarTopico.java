package alura.forumhub.domain.topico;

import alura.forumhub.domain.curso.Curso;
import alura.forumhub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCriarTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        LocalDateTime dataCriacao,

        @NotBlank
        StatusTopico status,

        @NotBlank
        Usuario usuario,

        @NotBlank
        Curso curso) {
}
