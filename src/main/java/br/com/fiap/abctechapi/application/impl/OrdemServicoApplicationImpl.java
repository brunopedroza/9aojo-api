package br.com.fiap.abctechapi.application.impl;

import br.com.fiap.abctechapi.application.OrdemServicoApplication;
import br.com.fiap.abctechapi.application.dto.LocalEHoraOSDto;
import br.com.fiap.abctechapi.application.dto.OrdemServicoDto;
import br.com.fiap.abctechapi.model.LocalEHoraOS;
import br.com.fiap.abctechapi.model.OrdemServico;
import br.com.fiap.abctechapi.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdemServicoApplicationImpl implements OrdemServicoApplication {

    private OrdemServicoService ordemServicoService;
    public OrdemServicoApplicationImpl(@Autowired OrdemServicoService ordemServicoService){
        this.ordemServicoService = ordemServicoService;
    }
    @Override
    public void criarOrdemServico(OrdemServicoDto ordemServicoDto) throws Exception {
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setIdPrestador(ordemServicoDto.getIdPrestador());
        ordemServico.setInicioAtendimento(getLocalEHoraOsfromLocalEHoraOSDto(ordemServicoDto.getInicioAtendimento()));
        ordemServico.setFimAtendimento(getLocalEHoraOsfromLocalEHoraOSDto(ordemServicoDto.getFimAtendimento()));
        this.ordemServicoService.salvarOrdemServico(ordemServico, ordemServicoDto.getServicos());
    }

    private LocalEHoraOS getLocalEHoraOsfromLocalEHoraOSDto(LocalEHoraOSDto localEHoraOSDto){
        LocalEHoraOS localEHoraOS = new LocalEHoraOS();
        localEHoraOS.setLatitude(localEHoraOSDto.getLatitude());
        localEHoraOS.setLongitude(localEHoraOSDto.getLongitude());
        localEHoraOS.setDataHora(localEHoraOSDto.getDataHora());
        return localEHoraOS;
    }
}
