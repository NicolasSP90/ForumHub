package alura.forumhub.gerenciadores;

import alura.forumhub.domain.perfil.DadosCriarPerfil;
import alura.forumhub.domain.perfil.DetalhesCriarPerfil;
import alura.forumhub.domain.perfil.Perfil;
import alura.forumhub.domain.perfil.PerfilRepository;
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
