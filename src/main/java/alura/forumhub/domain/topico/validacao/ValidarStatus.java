package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarStatus {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCriarTopico dados){
        if (dados.status().toString().isBlank()){
            throw new ValidacaoException("Status não informado");
        }

        if (!topicoRepository.existsByStatus(dados.status())){
            throw new ValidacaoException("Status inválido!");
        }
    }
}
