package alura.forumhub.domain.curso;

public record DetalhesCriarCurso(
        String nome,
        CategoriaCurso categoriaCurso) {

    public DetalhesCriarCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoriaCurso());
    }

}
