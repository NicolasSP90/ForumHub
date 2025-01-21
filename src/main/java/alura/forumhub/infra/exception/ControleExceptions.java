package alura.forumhub.infra.exception;

import alura.forumhub.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControleExceptions {

    @ExceptionHandler
    public ResponseEntity regrasNegocio(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
