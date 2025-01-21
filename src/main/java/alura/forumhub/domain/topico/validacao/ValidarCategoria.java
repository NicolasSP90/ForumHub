package alura.forumhub.domain.topico.validacao;

import alura.forumhub.ValidacaoException;
import alura.forumhub.domain.curso.CursoRepository;
import alura.forumhub.domain.topico.DadosCriarTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarCategoria {

    @Autowired
    private CursoRepository cursoRepository;

    public void validar(DadosCriarTopico dados){
        if (dados.categoria() == null){
            throw new ValidacaoException("Categoria do Curso nula");
        }

        if (dados.categoria().toString().isBlank()){
            throw new ValidacaoException("Categoria do Curso não informada");
        }

        if (!cursoRepository.existsByCategoriaCurso(dados.categoria())){
            throw new ValidacaoException("Categoria do Curso não encontrada");
        }
    }
}
