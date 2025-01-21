package alura.forumhub.controller;

import alura.forumhub.domain.usuario.DadosCriarUsuario;
import alura.forumhub.gerenciadores.GerenciarUsuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.PermitAll;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PermitAll
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class ControllerUsuario {

    @Autowired
    GerenciarUsuario usuario;

    @PermitAll
    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid DadosCriarUsuario dados){
        var dto  = usuario.criarUsuario(dados);
        return ResponseEntity.ok(dto);
    }
}
