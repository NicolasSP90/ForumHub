package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarUsuario {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCriarTopico dados){
        if (dados.idUsuario() == null){
            throw new ValidacaoException("Usuário nulo");
        }

        if (dados.idUsuario().toString().isBlank()){
            throw new ValidacaoException("Usuário não informado");
        }

        if (topicoRepository.existsByUsuarioId(dados.idUsuario())){
            throw new ValidacaoException("Usuário não encontrado");
        }
    }
}
