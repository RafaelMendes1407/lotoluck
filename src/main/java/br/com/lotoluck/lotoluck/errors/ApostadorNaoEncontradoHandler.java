package br.com.lotoluck.lotoluck.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApostadorNaoEncontradoHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ApostadorNaoEncontradoException.class})
    public ErroDeFormulario handle(Exception ex) {
        return new ErroDeFormulario("Email", "Email não está vinculado a nenhum apostador");
    }
}
