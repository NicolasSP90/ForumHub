package alura.forumhub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DadosCriarPerfil(
        @NotBlank
        String nome ) {
}
