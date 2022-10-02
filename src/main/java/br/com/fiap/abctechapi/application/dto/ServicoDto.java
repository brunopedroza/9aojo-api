package br.com.fiap.abctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServicoDto {
    private Long id;
    private String nome;
    private String descricao;
    private String categoria;

}
