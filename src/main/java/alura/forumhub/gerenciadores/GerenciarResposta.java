package alura.forumhub.gerenciadores;

import alura.forumhub.domain.resposta.DadosCriarResposta;
import alura.forumhub.domain.resposta.DetalhesCriarResposta;
import alura.forumhub.domain.resposta.Resposta;
import alura.forumhub.domain.resposta.RespostaRepository;
import alura.forumhub.domain.topico.TopicoRepository;
import alura.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DetalhesCriarResposta criarResposta(@Valid DadosCriarResposta dados){
        var topico = topicoRepository.getReferenceById(dados.idTopico());
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var resposta = new Resposta(dados, topico, usuario);
        respostaRepository.save(resposta);

        return new DetalhesCriarResposta(resposta);
    }
}
