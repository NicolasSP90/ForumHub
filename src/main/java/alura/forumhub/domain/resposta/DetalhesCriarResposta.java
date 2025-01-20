package alura.forumhub.domain.resposta;

import alura.forumhub.domain.topico.Topico;

public record DetalhesCriarResposta(
        Long id,
        String mensagem,
        Topico topico ) {

    public DetalhesCriarResposta(Resposta resposta){
        this(resposta.getId(), resposta.getMensagem(), resposta.getTopico());
    }
}
