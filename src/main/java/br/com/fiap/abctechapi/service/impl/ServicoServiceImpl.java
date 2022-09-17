package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.model.Servico;
import br.com.fiap.abctechapi.repository.ServicoRepository;
import br.com.fiap.abctechapi.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository repository;

    @Autowired
    public ServicoServiceImpl(ServicoRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Servico> getServicoList() {
        return repository.findAll();
    }
}
