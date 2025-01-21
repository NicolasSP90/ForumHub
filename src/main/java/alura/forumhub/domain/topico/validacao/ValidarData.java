package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidarData {

    public void validar(DadosCriarTopico dados){
        if (dados.dataCriacao() == null){
            throw new ValidacaoException("Data não informada ou inválida!");
        }
    }
}
