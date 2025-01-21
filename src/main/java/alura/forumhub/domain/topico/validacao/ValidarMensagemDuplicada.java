package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMensagemDuplicada implements ValidadorTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCriarTopico dados){
        if (topicoRepository.existsByMensagem(dados.mensagem())){
            throw new ValidacaoException("Mensagem já existe.");
        }
    }
}
