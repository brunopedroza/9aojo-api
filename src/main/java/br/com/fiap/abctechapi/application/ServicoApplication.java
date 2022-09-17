package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.ServicoDto;

import java.util.List;

public interface ServicoApplication {
    List<ServicoDto> getServicos();
}
