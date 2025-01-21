package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidarMensagem implements ValidadorTopico{

    public void validar(DadosCriarTopico dados){
        if (dados.mensagem().isBlank()){
            throw new ValidacaoException("Mensagem não informada!");
        }
    }




}
