package br.com.lotoluck.lotoluck.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErroSQLHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class, IllegalStateException.class })
    public ErroDeFormulario handle(Exception ex) {
        String fieldErro = ex.getMessage();
        return new ErroDeFormulario("Email", "Email já Cadastrado");
    }
}
