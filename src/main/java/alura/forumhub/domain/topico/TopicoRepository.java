package alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTitulo(@NotBlank String titulo);

    boolean existsByMensagem(@NotBlank String mensagem);

    boolean existsByStatus(@NotNull StatusTopico status);

    boolean existsByUsuarioId(@NotNull Long usuarioId);

    @Query("SELECT t FROM Topico t WHERE t.status <> 'DESATIVADO' ORDER BY t.dataCriacao ASC")
    Page<Topico> topicosAbertoFechado(Pageable pageable);
}
