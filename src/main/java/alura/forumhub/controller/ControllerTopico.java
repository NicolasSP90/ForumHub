package alura.forumhub.controller;

import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.DadosListagemTopicos;
import alura.forumhub.domain.topico.TopicoRepository;
import alura.forumhub.gerenciadores.GerenciarTopico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class ControllerTopico {

    @Autowired
    GerenciarTopico topico;

    @Autowired
    TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosCriarTopico dados) {
        var dto = topico.criarTopico(dados);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> carregarTopicos(@PageableDefault(size = 10) Pageable pageable) {
        var page = topicoRepository.topicosAbertoFechado(pageable).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }
}
