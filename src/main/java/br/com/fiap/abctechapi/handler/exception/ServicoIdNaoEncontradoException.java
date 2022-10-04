package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class ServicoIdNaoEncontradoException extends RuntimeException{

    private String description;

    public ServicoIdNaoEncontradoException(String message, String description){
        super(message);
        this.description = description;
    }

}
