package alura.forumhub.controller;

import alura.forumhub.domain.topico.GerenciarTopico;
import alura.forumhub.domain.topico.DadosCriarTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class ControllerTopico {

    @Autowired
    GerenciarTopico topico;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosCriarTopico dados) {
        var dto = topico.criarTopico(dados);
        return ResponseEntity.ok(dto);
    }
}
