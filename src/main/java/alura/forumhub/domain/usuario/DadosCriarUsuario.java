package alura.forumhub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCriarUsuario(
        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String senha ) {

}
