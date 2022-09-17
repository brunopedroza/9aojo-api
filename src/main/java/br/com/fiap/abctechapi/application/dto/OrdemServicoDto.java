package br.com.fiap.abctechapi.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrdemServicoDto {
    // considerar adicionar as anotações de validação de input
    private Long idPrestador;
    private List<Long> servicos;
    private LocalEHoraOSDto inicioAtendimento;
    private LocalEHoraOSDto fimAtendimento;

}
