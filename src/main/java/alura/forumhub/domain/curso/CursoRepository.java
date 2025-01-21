package alura.forumhub.domain.curso;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso getCursoByCategoriaCurso(@NotNull CategoriaCurso categoria);

    boolean existsByCategoriaCurso(@NotNull CategoriaCurso categoria);
}
