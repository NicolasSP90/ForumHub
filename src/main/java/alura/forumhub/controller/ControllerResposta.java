package alura.forumhub.controller;

import alura.forumhub.domain.resposta.DadosCriarResposta;
import alura.forumhub.gerenciadores.GerenciarResposta;
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
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class ControllerResposta {

    @Autowired
    GerenciarResposta resposta;

    @PostMapping
    @Transactional
    public ResponseEntity criarResposta(@RequestBody @Valid DadosCriarResposta dados) {
        var dto = resposta.criarResposta(dados);
        return ResponseEntity.ok(dto);
    }
}
