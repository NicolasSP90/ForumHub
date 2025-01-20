package alura.forumhub.controller;

import alura.forumhub.domain.usuario.DadosCriarUsuario;
import alura.forumhub.domain.usuario.GerenciarUsuario;
import alura.forumhub.domain.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class ControllerUsuario {

    @Autowired
    GerenciarUsuario usuario;

    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid DadosCriarUsuario dados){
        var dto  = usuario.criarUsuario(dados);
        return ResponseEntity.ok(dto);
    }
}
