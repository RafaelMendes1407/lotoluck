package br.com.lotoluck.lotoluck.errors;

public class ApostadorNaoEncontradoException extends RuntimeException {
    public ApostadorNaoEncontradoException(String errorMessage) {
        super(errorMessage);
    }
}
