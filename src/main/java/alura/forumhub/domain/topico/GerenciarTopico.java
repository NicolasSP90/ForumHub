package alura.forumhub.domain.topico;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    public DetalhesCriarTopico criarTopico(@Valid DadosCriarTopico dados) {

        var topico = new Topico(dados);
        topicoRepository.save(topico);

        return new DetalhesCriarTopico(topico);
    }
}
