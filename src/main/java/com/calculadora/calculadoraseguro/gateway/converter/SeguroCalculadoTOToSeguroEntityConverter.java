package com.calculadora.calculadoraseguro.gateway.converter;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoTO;
import org.springframework.stereotype.Component;

@Component
public class SeguroCalculadoTOToSeguroEntityConverter {
    public SeguroEntity convert(SeguroCalculadoTO seguroCalculadoTO) {
        SeguroEntity seguroEntity = new SeguroEntity();
        seguroEntity.setId(seguroCalculadoTO.getId());
        seguroEntity.setNome(seguroCalculadoTO.getNome());
        seguroEntity.setCategoria(seguroCalculadoTO.getSeguroCategoria());
        seguroEntity.setPrecoBase(seguroCalculadoTO.getPrecoBase());
        seguroEntity.setPrecoTarifado(seguroCalculadoTO.getPrecoTarifado());
        return seguroEntity;
    }
}
