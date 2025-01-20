package alura.forumhub.domain.perfil;

public record DetalhesCriarPerfil(
        String nome ) {

    public DetalhesCriarPerfil(Perfil perfil) {
        this(perfil.getNome());

    }
}
