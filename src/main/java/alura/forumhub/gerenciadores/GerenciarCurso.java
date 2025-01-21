package alura.forumhub.gerenciadores;

import alura.forumhub.domain.curso.Curso;
import alura.forumhub.domain.curso.CursoRepository;
import alura.forumhub.domain.curso.DadosCriarCurso;
import alura.forumhub.domain.curso.DetalhesCriarCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarCurso {

    @Autowired
    private CursoRepository cursoRepository;

    public DetalhesCriarCurso criarCurso(@Valid DadosCriarCurso dados){
        var curso = new Curso(dados);
        cursoRepository.save(curso);

        return new DetalhesCriarCurso(curso);
    }
}
