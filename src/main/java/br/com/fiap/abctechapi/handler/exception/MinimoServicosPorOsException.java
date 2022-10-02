package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MinimoServicosPorOsException extends RuntimeException {

    private String description;

    public MinimoServicosPorOsException(String message, String description){
        super(message);
        this.description = description;
    }

}
