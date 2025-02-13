package alura.forumhub.controller;

import alura.forumhub.domain.curso.DadosCriarCurso;
import alura.forumhub.gerenciadores.GerenciarCurso;
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
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class ControllerCurso {

    @Autowired
    GerenciarCurso curso;

    @PostMapping
    @Transactional
    public ResponseEntity criarCurso(@RequestBody @Valid DadosCriarCurso dados) {
        var dto = curso.criarCurso(dados);
        return ResponseEntity.ok(dto);
    }
}
