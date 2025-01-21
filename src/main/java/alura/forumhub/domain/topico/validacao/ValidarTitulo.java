package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidarTitulo implements ValidadorTopico{

    public void validar(DadosCriarTopico dados){
        if (dados.titulo().isBlank()){
            throw new ValidacaoException("Título não informado!");
        }
    }

}
