package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.OrdemServicoDto;
import br.com.fiap.abctechapi.application.dto.OrdemServicoResponseDto;

import java.util.List;

public interface OrdemServicoApplication {
    void criarOrdemServico(OrdemServicoDto ordemServicoDto) throws Exception;

    List<OrdemServicoResponseDto> listarOsPorPrestador(Long idPrestador);
}
