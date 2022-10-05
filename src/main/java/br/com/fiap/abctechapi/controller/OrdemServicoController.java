package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.OrdemServicoApplication;
import br.com.fiap.abctechapi.application.dto.OrdemServicoDto;
import br.com.fiap.abctechapi.application.dto.OrdemServicoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoController {

    private OrdemServicoApplication ordemServicoApplication;

    public OrdemServicoController (@Autowired OrdemServicoApplication ordemServicoApplication){
        this.ordemServicoApplication = ordemServicoApplication;
    }

    @PostMapping
    public ResponseEntity criarOrdemServico(@RequestBody OrdemServicoDto ordemServicoDto) throws Exception {
        ordemServicoApplication.criarOrdemServico(ordemServicoDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/prestador/{idPrestador}")
    @ResponseBody
    public ResponseEntity<List<OrdemServicoResponseDto>> listOrdersOperator(@PathVariable Long idPrestador){
        return ResponseEntity.ok(ordemServicoApplication.listarOsPorPrestador(idPrestador));
    }
}
