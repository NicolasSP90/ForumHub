package alura.forumhub.gerenciadores;

import alura.forumhub.domain.curso.CursoRepository;
import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.DetalhesCriarTopico;
import alura.forumhub.domain.topico.Topico;
import alura.forumhub.domain.topico.TopicoRepository;
import alura.forumhub.domain.topico.validacao.ValidadorTopico;
import alura.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciarTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorTopico> validacaoTopico;

    public DetalhesCriarTopico criarTopico( DadosCriarTopico dados) {

        validacaoTopico.forEach(v -> v.validar(dados));

        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var curso = cursoRepository.getCursoByCategoriaCurso(dados.categoria());
        var topico = new Topico(dados, usuario, curso);
        topicoRepository.save(topico);
        return new DetalhesCriarTopico(topico);
    }
}
