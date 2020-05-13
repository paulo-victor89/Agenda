package com.treinamento.demo.exception;

public class ObjetoInexistenteException extends RuntimeException {
	
    private Integer code = 2;

    public ObjetoInexistenteException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

}
