package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.OrdemServicoDto;

public interface OrdemServicoApplication {
    void criarOrdemServico(OrdemServicoDto ordemServicoDto) throws Exception;
}
