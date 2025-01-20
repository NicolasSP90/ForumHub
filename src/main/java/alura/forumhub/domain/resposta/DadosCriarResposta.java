package alura.forumhub.domain.resposta;

import alura.forumhub.domain.topico.Topico;
import alura.forumhub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCriarResposta(
        @NotBlank
        String mensagem,

        @NotNull
        Topico topico,

        @NotNull
        @JsonAlias("data_criacao") LocalDateTime dataCriacao,

        @NotNull
        Usuario usuario) {

}
