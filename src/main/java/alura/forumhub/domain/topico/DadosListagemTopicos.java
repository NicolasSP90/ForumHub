package alura.forumhub.domain.topico;

import alura.forumhub.domain.curso.Curso;
import alura.forumhub.domain.resposta.Resposta;
import alura.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        Usuario usuario,
        Curso curso,
        List<Resposta> respostas ) {

    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getUsuario(), topico.getCurso(), topico.getRespostas());
    }
}
