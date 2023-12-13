package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CriarSeguro {
    private final SeguroCalculadoConverter seguroCalculadoConverter;
    private final SeguroService seguroService;
    private final CalcularPrecoSeguro calcularPrecoSeguro;

    public SeguroCalculadoDTO executar(SeguroDTO seguroDTO) {
        log.info("Entrou na classe Criar Seguro");

        var seguroCalculadoTO = gerarSeguroCalculadoTO(seguroDTO);

        var seguroEntity = salvarSeguro(seguroCalculadoTO);

        return converterSeguroEntityParaCalculadoTO(seguroEntity);
    }

    private SeguroCalculadoDTO gerarSeguroCalculadoTO(SeguroDTO seguroDTO){
        log.info("Gerando Seguro Calculado DTO");
        var seguroCalculadoDTO = new SeguroCalculadoDTO();
        seguroCalculadoDTO.setNome(seguroDTO.getNome());
        seguroCalculadoDTO.setSeguroCategoria(seguroDTO.getSeguroCategoria());
        seguroCalculadoDTO.setPrecoBase(seguroDTO.getPrecoBase());
        seguroCalculadoDTO.setPrecoTarifado(calcularPrecoSeguro.executar(seguroDTO.getPrecoBase(), seguroDTO.getSeguroCategoria()));

        return seguroCalculadoDTO;

    }

    private SeguroEntity salvarSeguro(SeguroCalculadoDTO seguroCalculadoDTO) {
        return seguroService.salvarSeguro(seguroCalculadoConverter.convertDTOtoEntity(seguroCalculadoDTO));
    }

    private SeguroCalculadoDTO converterSeguroEntityParaCalculadoTO(SeguroEntity seguroEntity) {
        return seguroCalculadoConverter.converterEntityToDTO(seguroEntity);
    }
}