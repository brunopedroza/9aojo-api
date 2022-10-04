package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.handler.exception.MaximoServicosPorOsException;
import br.com.fiap.abctechapi.handler.exception.MinimoServicosPorOsException;
import br.com.fiap.abctechapi.handler.exception.ServicoIdNaoEncontradoException;
import br.com.fiap.abctechapi.model.OrdemServico;
import br.com.fiap.abctechapi.model.Servico;
import br.com.fiap.abctechapi.repository.OrdemServicoRepository;
import br.com.fiap.abctechapi.repository.ServicoRepository;
import br.com.fiap.abctechapi.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {
    private OrdemServicoRepository ordemServicoRepository;
    private ServicoRepository servicoRepository;

    public OrdemServicoServiceImpl (
            @Autowired OrdemServicoRepository ordemServicoRepository,
            @Autowired ServicoRepository servicoRepository ) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.servicoRepository = servicoRepository;
    }

    @Override
    public void salvarOrdemServico(OrdemServico ordemServico, List<Long> arrayServicos) throws Exception {
        ArrayList<Servico> servicos = new ArrayList<>();
        arrayServicos.forEach( i -> {
            Servico servico = servicoRepository.findById(i).orElseThrow(() -> new ServicoIdNaoEncontradoException("ID do serviço não encontrada","Insira somente IDs de serviços válidas"));
            servicos.add(servico);
        });

        ordemServico.setServicos(servicos);

        if(!ordemServico.temServicosMin()){
            throw new MinimoServicosPorOsException("Lista de serviços inválida","Não há serviços listados nesta OS, adicione pelo menos 1 serviço e tente novamente.");
        } else if (ordemServico.ultrapassaServicosMax()){
            throw new MaximoServicosPorOsException("Lista de serviços inválida","Quantidade máxima de 15 serviços excedida.");
        }
        ordemServicoRepository.save(ordemServico);

    }

    @Override
    public List<OrdemServico> listarOsPorPrestador(Long idPrestador) {
        return null;
          //ordemServicoRepository.findById(idPrestador).orElseThrow();
    }
}
