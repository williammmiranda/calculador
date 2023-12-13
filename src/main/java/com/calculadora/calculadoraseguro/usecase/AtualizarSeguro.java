package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AtualizarSeguro {
    private final SeguroCalculadoConverter seguroCalculadoConverter;
    private final SeguroService seguroService;
    private final CalcularPrecoSeguro calcularPrecoSeguro;

    public SeguroCalculadoDTO executar(SeguroTO seguroTO, String id) {
        log.info("Entrou na Classe de Atualizar o Seguro com id: {}", id);
        var seguroCalculadoTO = converterSeguroEntityParaCalculadoTO(seguroService.buscarSeguro(id));

        preencherSeguroTO(seguroTO, seguroCalculadoTO);

        var seguroEntity = salvarSeguro(seguroCalculadoTO);

        return converterSeguroEntityParaCalculadoTO(seguroEntity);
    }

    private void preencherSeguroTO(SeguroTO seguroTO,  SeguroCalculadoDTO seguroCalculadoDTO){
        log.info("Valida envio valores na Classe de Atualizar o Seguro com id");
        seguroCalculadoDTO.setPrecoBase(seguroTO.getPrecoBase() != null ? seguroTO.getPrecoBase() : seguroCalculadoDTO.getPrecoBase());
        seguroCalculadoDTO.setSeguroCategoria(seguroTO.getSeguroCategoria() != null ? seguroTO.getSeguroCategoria() : seguroCalculadoDTO.getSeguroCategoria());
        seguroCalculadoDTO.setNome(seguroTO.getNome() != null ? seguroTO.getNome() : seguroCalculadoDTO.getNome());
        seguroCalculadoDTO.setPrecoTarifado(calcularPrecoSeguro.executar(seguroCalculadoDTO.getPrecoBase(), seguroCalculadoDTO.getSeguroCategoria()));

    }

    private SeguroEntity salvarSeguro(SeguroCalculadoDTO seguroCalculadoDTO) {
        return seguroService.salvarSeguro(seguroCalculadoConverter.convertDTOtoEntity(seguroCalculadoDTO));
    }

    private SeguroCalculadoDTO converterSeguroEntityParaCalculadoTO(SeguroEntity seguroEntity) {
        return seguroCalculadoConverter.converterEntityToDTO(seguroEntity);
    }
}