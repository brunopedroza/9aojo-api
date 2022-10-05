package br.com.fiap.abctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrdemServicoResponseDto {

    public Long id;
    private Long idPrestador;
    private List<ServicoDto> servicos;
    private LocalEHoraOSDto inicioAtendimento;
    private LocalEHoraOSDto fimAtendimento;

}
