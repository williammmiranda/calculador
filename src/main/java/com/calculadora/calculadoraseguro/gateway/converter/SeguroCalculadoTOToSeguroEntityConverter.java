package com.calculadora.calculadoraseguro.gateway.converter;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import org.springframework.stereotype.Component;

@Component
public class SeguroCalculadoTOToSeguroEntityConverter {
    public SeguroEntity convert(SeguroCalculadoDTO seguroCalculadoDTO) {
        SeguroEntity seguroEntity = new SeguroEntity();
        seguroEntity.setId(seguroCalculadoDTO.getId());
        seguroEntity.setNome(seguroCalculadoDTO.getNome());
        seguroEntity.setCategoria(seguroCalculadoDTO.getSeguroCategoria());
        seguroEntity.setPrecoBase(seguroCalculadoDTO.getPrecoBase());
        seguroEntity.setPrecoTarifado(seguroCalculadoDTO.getPrecoTarifado());
        return seguroEntity;
    }
}
