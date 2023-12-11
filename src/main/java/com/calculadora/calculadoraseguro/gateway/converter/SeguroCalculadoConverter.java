package com.calculadora.calculadoraseguro.gateway.converter;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import org.springframework.stereotype.Component;

@Component
public class SeguroCalculadoConverter {
    public SeguroEntity convertDTOtoEntity(SeguroCalculadoDTO seguroCalculadoDTO) {
        SeguroEntity seguroEntity = new SeguroEntity();
        seguroEntity.setId(seguroCalculadoDTO.getId());
        seguroEntity.setNome(seguroCalculadoDTO.getNome());
        seguroEntity.setCategoria(seguroCalculadoDTO.getSeguroCategoria());
        seguroEntity.setPrecoBase(seguroCalculadoDTO.getPrecoBase());
        seguroEntity.setPrecoTarifado(seguroCalculadoDTO.getPrecoTarifado());
        return seguroEntity;
    }

    public SeguroCalculadoDTO converterEntityToDTO(SeguroEntity seguroEntity) {

        var seguroCalculadoDTO = new SeguroCalculadoDTO();

        seguroCalculadoDTO.setId(seguroEntity.getId());
        seguroCalculadoDTO.setNome(seguroEntity.getNome());
        seguroCalculadoDTO.setSeguroCategoria(seguroEntity.getCategoria());
        seguroCalculadoDTO.setPrecoBase(seguroEntity.getPrecoBase());
        seguroCalculadoDTO.setPrecoTarifado(seguroEntity.getPrecoTarifado());

        return seguroCalculadoDTO;

    }
}
