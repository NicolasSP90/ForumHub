package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoDuplicado implements ValidadorTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCriarTopico dados) {
        if (topicoRepository.existsByTitulo(dados.titulo())){
            throw new ValidacaoException("Tópico já existe.");
        }
    }
}
