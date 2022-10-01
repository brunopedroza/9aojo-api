package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.model.OrdemServico;

import java.util.List;

public interface OrdemServicoService {

    void salvarOrdemServico(OrdemServico ordemServico, List<Long> arrayServicos) throws Exception;
    List<OrdemServico> listarOsPorPrestador(Long idPrestador);

}
