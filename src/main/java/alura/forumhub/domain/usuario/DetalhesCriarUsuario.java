package alura.forumhub.domain.usuario;

public record DetalhesCriarUsuario(
        Long id,
        String nome,
        String email ) {

    public DetalhesCriarUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNome(),usuario.getEmail());
    }

}
