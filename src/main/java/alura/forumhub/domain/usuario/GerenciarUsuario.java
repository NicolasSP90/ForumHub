package alura.forumhub.domain.usuario;

import jakarta.validation.Valid;

public class GerenciarUsuario {
    public DetalhesCriarUsuario criarUsuario(@Valid DadosCriarUsuario dados) {

        var usuario = new Usuario(dados);

        return new DetalhesCriarUsuario(usuario);
    }
}
