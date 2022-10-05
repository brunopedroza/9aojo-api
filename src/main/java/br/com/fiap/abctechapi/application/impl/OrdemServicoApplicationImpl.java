package br.com.fiap.abctechapi.application.impl;

import br.com.fiap.abctechapi.application.OrdemServicoApplication;
import br.com.fiap.abctechapi.application.dto.LocalEHoraOSDto;
import br.com.fiap.abctechapi.application.dto.OrdemServicoDto;
import br.com.fiap.abctechapi.application.dto.OrdemServicoResponseDto;
import br.com.fiap.abctechapi.application.dto.ServicoDto;
import br.com.fiap.abctechapi.model.LocalEHoraOS;
import br.com.fiap.abctechapi.model.OrdemServico;
import br.com.fiap.abctechapi.model.Servico;
import br.com.fiap.abctechapi.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<OrdemServicoResponseDto> listarOsPorPrestador(Long idPrestador){
        return ordemServicoService.listarOsPorPrestador(idPrestador).stream().map(
                (ordemServico) -> new OrdemServicoResponseDto(ordemServico.getId(), ordemServico.getIdPrestador(), ordemServico.getServicos().stream().map(this::mapServicoToDto).collect(Collectors.toList()), maplocalEHoraOsToDto(ordemServico.getInicioAtendimento()), maplocalEHoraOsToDto(ordemServico.getFimAtendimento()))
        ).collect(Collectors.toList());
    }
    private ServicoDto mapServicoToDto(Servico servico){
        return new ServicoDto(servico.getId(), servico.getNome(), servico.getDescricao(), servico.getCategoria());
    }
    private LocalEHoraOS getLocalEHoraOsfromLocalEHoraOSDto(LocalEHoraOSDto localEHoraOSDto){
        LocalEHoraOS localEHoraOS = new LocalEHoraOS();
        localEHoraOS.setLatitude(localEHoraOSDto.getLatitude());
        localEHoraOS.setLongitude(localEHoraOSDto.getLongitude());
        localEHoraOS.setDataHora(localEHoraOSDto.getDataHora());
        return localEHoraOS;
    }

    private LocalEHoraOSDto maplocalEHoraOsToDto(LocalEHoraOS localEHoraOS){
        LocalEHoraOSDto localEHoraOSDto = new LocalEHoraOSDto();
        localEHoraOSDto.setLatitude(localEHoraOS.getLatitude());
        localEHoraOSDto.setLongitude(localEHoraOS.getLongitude());
        localEHoraOSDto.setDataHora(localEHoraOS.getDataHora());
        return localEHoraOSDto;
    }





}
