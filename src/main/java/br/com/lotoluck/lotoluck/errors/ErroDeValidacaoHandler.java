package br.com.lotoluck.lotoluck.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<ErroDeFormulario> handle(ConstraintViolationException ex) {
        List<ErroDeFormulario> fieldErro = new ArrayList<>();
        ex.getConstraintViolations().forEach(e -> {
            fieldErro.add(new ErroDeFormulario(e.getPropertyPath().toString(), e.getMessage()));
        });

        return fieldErro;
    }
}