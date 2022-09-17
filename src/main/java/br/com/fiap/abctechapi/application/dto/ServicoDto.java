package br.com.fiap.abctechapi.application.dto;

import lombok.Data;

@Data
public class ServicoDto {
    // considerar adicionar as anotações de validação de input
    private Long id;
    private String nome;
    private String descricao;

}
