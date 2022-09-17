package br.com.fiap.abctechapi.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LocalEHoraOSDto {
    // considerar adicionar as anotações de validação de input
    private Double latitude;
    private Double longitude;
    private Date dataHora;
}

