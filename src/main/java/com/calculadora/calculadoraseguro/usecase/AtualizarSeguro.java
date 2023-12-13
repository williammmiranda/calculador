package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class AtualizarSeguro {
    private final SeguroCalculadoConverter seguroCalculadoConverter;
    private final SeguroService seguroService;
    private final CalcularPrecoSeguro calcularPrecoSeguro;

    public SeguroCalculadoDTO executar(SeguroDTO seguroDTO, String id) {
        log.info("Entrou na Classe de Atualizar o Seguro com id: {}", id);
        var seguroBuscaEntity = seguroService.buscarSeguro(id);
        var seguroCalculadoTO = converterSeguroEntityParaCalculadoTO(seguroBuscaEntity);

        preencherSeguroTO(seguroDTO, seguroCalculadoTO);

        var seguroEntity = salvarSeguro(seguroCalculadoTO, seguroBuscaEntity.getDataInclusao());

        return converterSeguroEntityParaCalculadoTO(seguroEntity);
    }

    private void preencherSeguroTO(SeguroDTO seguroDTO, SeguroCalculadoDTO seguroCalculadoDTO){
        log.info("Valida envio valores na Classe de Atualizar o Seguro com id");
        seguroCalculadoDTO.setPrecoBase(seguroDTO.getPrecoBase() != null ? seguroDTO.getPrecoBase() : seguroCalculadoDTO.getPrecoBase());
        seguroCalculadoDTO.setSeguroCategoria(seguroDTO.getSeguroCategoria() != null ? seguroDTO.getSeguroCategoria() : seguroCalculadoDTO.getSeguroCategoria());
        seguroCalculadoDTO.setNome(seguroDTO.getNome() != null ? seguroDTO.getNome() : seguroCalculadoDTO.getNome());
        seguroCalculadoDTO.setPrecoTarifado(calcularPrecoSeguro.executar(seguroCalculadoDTO.getPrecoBase(), seguroCalculadoDTO.getSeguroCategoria()));

    }

    private SeguroEntity salvarSeguro(SeguroCalculadoDTO seguroCalculadoDTO, LocalDateTime dataInclusao) {
        return seguroService.salvarSeguro(seguroCalculadoConverter.convertDTOtoEntity(seguroCalculadoDTO, dataInclusao, LocalDateTime.now()));
    }

    private SeguroCalculadoDTO converterSeguroEntityParaCalculadoTO(SeguroEntity seguroEntity) {
        return seguroCalculadoConverter.converterEntityToDTO(seguroEntity);
    }
}