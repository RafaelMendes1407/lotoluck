package br.com.lotoluck.lotoluck.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroSQLHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class, IllegalStateException.class })
    public List<ErroDeFormulario> handle(Exception ex) {
        List<ErroDeFormulario> fieldErro = new ArrayList<>();
        System.out.println(ex.getMessage());
        ErroDeFormulario erro = new ErroDeFormulario("Email", "Email já cadastrado");
        fieldErro.add(erro);
        return fieldErro;
    }
}
