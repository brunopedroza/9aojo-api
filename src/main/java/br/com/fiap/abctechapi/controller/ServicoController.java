package br.com.fiap.abctechapi.controller;


import br.com.fiap.abctechapi.model.Servico;
import br.com.fiap.abctechapi.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService service;

    @Autowired
    public ServicoController(ServicoService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Servico>> getServicos(){
        List<Servico> list = service.getServicoList();
        return ResponseEntity.ok(list);
    }

}