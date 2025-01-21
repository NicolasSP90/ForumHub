package alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTitulo(@NotBlank String titulo);

    boolean existsByMensagem(@NotBlank String mensagem);

    boolean existsByStatus(@NotNull StatusTopico status);

    boolean existsByUsuarioId(@NotNull Long usuarioId);
}
