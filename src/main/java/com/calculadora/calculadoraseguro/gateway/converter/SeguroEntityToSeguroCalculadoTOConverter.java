package com.calculadora.calculadoraseguro.gateway.converter;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import org.springframework.stereotype.Component;

@Component
public class SeguroEntityToSeguroCalculadoTOConverter {

    public SeguroCalculadoDTO convert(SeguroEntity seguroEntity) {
        SeguroCalculadoDTO seguroCalculadoDTO = new SeguroCalculadoDTO();
        seguroCalculadoDTO.setId(seguroEntity.getId());
        seguroCalculadoDTO.setNome(seguroEntity.getNome());
        seguroCalculadoDTO.setSeguroCategoria(seguroEntity.getCategoria());
        seguroCalculadoDTO.setPrecoBase(seguroEntity.getPrecoBase());
        seguroCalculadoDTO.setPrecoTarifado(seguroEntity.getPrecoTarifado());
        return seguroCalculadoDTO;
    }
}
