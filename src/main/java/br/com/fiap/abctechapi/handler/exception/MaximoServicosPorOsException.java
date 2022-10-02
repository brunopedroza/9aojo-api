package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MaximoServicosPorOsException extends RuntimeException{
    private String description;

    public MaximoServicosPorOsException(String message, String description){
        super(message);
        this.description = description;
    }
}
