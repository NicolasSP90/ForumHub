package alura.forumhub.gerenciadores;

import alura.forumhub.domain.curso.CursoRepository;
import alura.forumhub.domain.topico.*;
import alura.forumhub.domain.topico.validacao.ValidadorTopico;
import alura.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GerenciarTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorTopico> validacaoTopico;

    public DetalhesCriarTopico criarTopico( DadosCriarTopico dados) {

        validacaoTopico.forEach(v -> v.validar(dados));

        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var curso = cursoRepository.getCursoByCategoriaCurso(dados.categoria());
        var topico = new Topico(dados, usuario, curso);
        topicoRepository.save(topico);
        return new DetalhesCriarTopico(topico);
    }

    public ResponseEntity verificarCarregarTopico(Long id) {
        var verificaTopico = verificarSeExisteTopico(id);

        if (verificarSeExisteTopico(id) != null) {
            return verificaTopico;

        } else {
            var topicoResgatado = topicoRepository.retornaTopico(id);
            var detalhesTopico = new DetalhesCriarTopico(topicoResgatado);
            return ResponseEntity.ok(detalhesTopico);
        }
    }

    public ResponseEntity editarTopico(@Valid Long id, @Valid DadosEditarTopico dados) {
        var verificaTopico = verificarSeExisteTopico(id);

        if (verificarSeExisteTopico(id) != null) {
            return verificaTopico;

        } else {
            var topicoResgatado = topicoRepository.retornaTopico(id);

            if (!Objects.equals(topicoResgatado.getTitulo(), dados.titulo())) {
                topicoResgatado.atualizarTitulo(dados.titulo());
            }

            if (!Objects.equals(topicoResgatado.getMensagem(), dados.mensagem())) {
                topicoResgatado.atualizarMensagem(dados.mensagem());
            }

            topicoRepository.save(topicoResgatado);

            return ResponseEntity.ok().body(new DetalhesCriarTopico(topicoResgatado));
        }
    }

    public ResponseEntity abrirTopico(Long id) {
        var topicoResgatado = topicoRepository.retornaTopico(id);

        if (topicoResgatado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não existe.");
        } else {
            topicoResgatado.abrirTopico();
            topicoRepository.save(topicoResgatado);
            return ResponseEntity.ok().body("Topico id:%s foi ativado.".formatted(id));
        }
    }

    public ResponseEntity fecharTopico(Long id) {
        var verificaTopico = verificarSeExisteTopico(id);

        if (verificarSeExisteTopico(id) != null) {
            return verificaTopico;
        } else {
            var topicoResgatado = topicoRepository.retornaTopico(id);
            topicoResgatado.fecharTopico();
            topicoRepository.save(topicoResgatado);
            return ResponseEntity.ok().body("Topico id:%s foi fechado.".formatted(id));
        }
    }

    public ResponseEntity desativarTopico(Long id) {
        var verificaTopico = verificarSeExisteTopico(id);

        if (verificarSeExisteTopico(id) != null) {
            return verificaTopico;
        } else {
            var topicoResgatado = topicoRepository.retornaTopico(id);
            topicoResgatado.desativarTopico();
            topicoRepository.save(topicoResgatado);
            return ResponseEntity.ok().body("Topico id:%s foi desativado.".formatted(id));
        }
    }

    public ResponseEntity deletarTopico(Long id) {
        var topicoResgatado = topicoRepository.retornaTopico(id);

        if (topicoResgatado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não existe.");
        } else {
            topicoRepository.delete(topicoResgatado);
            return ResponseEntity.noContent().build();
        }
    }

    private ResponseEntity verificarSeExisteTopico(Long id) {
        var topicoResgatado = topicoRepository.retornaTopico(id);

        if (topicoResgatado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não existe.");
        }

        if (topicoResgatado.getStatus().toString().equals("DESATIVADO")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico foi desativado.");
        }

        return null;
    }


}
