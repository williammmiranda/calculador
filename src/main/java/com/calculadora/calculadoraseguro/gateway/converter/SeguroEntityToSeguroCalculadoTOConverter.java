package com.calculadora.calculadoraseguro.gateway.converter;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoTO;
import org.springframework.stereotype.Component;

@Component
public class SeguroEntityToSeguroCalculadoTOConverter {

    public SeguroCalculadoTO convert(SeguroEntity seguroEntity) {
        SeguroCalculadoTO seguroCalculadoTO = new SeguroCalculadoTO();
        seguroCalculadoTO.setId(seguroEntity.getId());
        seguroCalculadoTO.setNome(seguroEntity.getNome());
        seguroCalculadoTO.setSeguroCategoria(seguroEntity.getCategoria());
        seguroCalculadoTO.setPrecoBase(seguroEntity.getPrecoBase());
        seguroCalculadoTO.setPrecoTarifado(seguroEntity.getPrecoTarifado());
        return seguroCalculadoTO;
    }
}
