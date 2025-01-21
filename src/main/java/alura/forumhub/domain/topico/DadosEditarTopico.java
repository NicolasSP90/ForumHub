package alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEditarTopico(
        @NotNull
        Long id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem
) {
}
