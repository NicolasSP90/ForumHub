package alura.forumhub.domain.perfil;

import alura.forumhub.domain.topico.DetalhesCriarTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarPerfil {

    @Autowired
    private PerfilRepository perfilRepository;

    public DetalhesCriarPerfil criarPerfil(@Valid DadosCriarPerfil dados){
        var perfil = new Perfil(dados);
        perfilRepository.save(perfil);
        return new DetalhesCriarPerfil(perfil);
    }
}
