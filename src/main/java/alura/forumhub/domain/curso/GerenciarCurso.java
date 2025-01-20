package alura.forumhub.domain.curso;

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
