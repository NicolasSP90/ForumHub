package alura.forumhub.gerenciadores;

import alura.forumhub.domain.usuario.DadosCriarUsuario;
import alura.forumhub.domain.usuario.DetalhesCriarUsuario;
import alura.forumhub.domain.usuario.Usuario;
import alura.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DetalhesCriarUsuario criarUsuario(@Valid DadosCriarUsuario dados) {

        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);

        return new DetalhesCriarUsuario(usuario);
    }
}
