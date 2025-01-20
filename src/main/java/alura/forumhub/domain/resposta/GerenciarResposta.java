package alura.forumhub.domain.resposta;

import alura.forumhub.domain.topico.DetalhesCriarTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    public DetalhesCriarResposta criarResposta(@Valid DadosCriarResposta dados){

        var resposta = new Resposta(dados);
        respostaRepository.save(resposta);

        return new DetalhesCriarResposta(resposta);
    }
}
