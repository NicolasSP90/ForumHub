package alura.forumhub.controller;

import alura.forumhub.domain.topico.DadosCriarTopico;
import alura.forumhub.domain.topico.DadosEditarTopico;
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
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity carregarTopico(@PathVariable Long id) {
        return topico.verificarCarregarTopico(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity editarTopico(@PathVariable Long id, @RequestBody @Valid DadosEditarTopico dados) {
        return topico.editarTopico(id, dados);
    }

    // Abrir Tópico
    @PutMapping("/{id}/abrir")
    public ResponseEntity abrirTopico(@PathVariable Long id) {
        return topico.abrirTopico(id);
    }

    // Fechar Tópico
    @PutMapping("/{id}/fechar")
    public ResponseEntity fecharTopico(@PathVariable Long id) {
        return topico.fecharTopico(id);
    }

    // Desativar Tópico - Exclusão Lógica
    @PutMapping("/{id}/desativar")
    public ResponseEntity desativarTopico(@PathVariable Long id) {
        return topico.desativarTopico(id);
    }

    // Exclusão - REAL
    @DeleteMapping("/{id}/deletar")
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        return topico.deletarTopico(id);
    }


}
