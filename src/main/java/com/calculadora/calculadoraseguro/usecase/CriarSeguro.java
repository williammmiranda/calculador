package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarSeguro {
    private final SeguroCalculadoConverter seguroCalculadoConverter;
    private final SeguroService seguroService;
    private final CalcularPrecoSeguro calcularPrecoSeguro;

    public SeguroCalculadoDTO executar(SeguroTO seguroTO) {

        var seguroCalculadoTO = gerarSeguroCalculadoTO(seguroTO);

        var seguroEntity = salvarSeguro(seguroCalculadoTO);

        return converterSeguroEntityParaCalculadoTO(seguroEntity);
    }

    private SeguroCalculadoDTO gerarSeguroCalculadoTO(SeguroTO seguroTO){
        var seguroCalculadoDTO = new SeguroCalculadoDTO();
        seguroCalculadoDTO.setNome(seguroTO.getNome());
        seguroCalculadoDTO.setSeguroCategoria(seguroTO.getSeguroCategoria());
        seguroCalculadoDTO.setPrecoBase(seguroTO.getPrecoBase());
        seguroCalculadoDTO.setPrecoTarifado(calcularPrecoSeguro.executar(seguroTO.getPrecoBase(), seguroTO.getSeguroCategoria()));

        return seguroCalculadoDTO;

    }

    private SeguroEntity salvarSeguro(SeguroCalculadoDTO seguroCalculadoDTO) {
        return seguroService.salvarSeguro(seguroCalculadoConverter.convertDTOtoEntity(seguroCalculadoDTO));
    }

    private SeguroCalculadoDTO converterSeguroEntityParaCalculadoTO(SeguroEntity seguroEntity) {
        return seguroCalculadoConverter.converterEntityToDTO(seguroEntity);
    }
}