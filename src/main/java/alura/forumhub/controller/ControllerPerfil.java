package alura.forumhub.controller;

import alura.forumhub.domain.perfil.DadosCriarPerfil;
import alura.forumhub.gerenciadores.GerenciarPerfil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfis")
@SecurityRequirement(name = "bearer-key")
public class ControllerPerfil {

    @Autowired
    GerenciarPerfil perfil;

    @PostMapping
    @Transactional
    public ResponseEntity criarPerfil(@RequestBody @Valid DadosCriarPerfil dados) {
        var dto = perfil.criarPerfil(dados);
        return ResponseEntity.ok(dto);
    }
}
