package com.calculadora.calculadoraseguro.gateway.converter;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class SeguroCalculadoConverter {
    public SeguroEntity convertDTOtoEntity(SeguroCalculadoDTO seguroCalculadoDTO, LocalDateTime dataInclusacao, LocalDateTime dataAlteracao) {
        log.info("Convertendo DTO em Entity do Seguro");
        SeguroEntity seguroEntity = new SeguroEntity();
        seguroEntity.setId(seguroCalculadoDTO.getId());
        seguroEntity.setNome(seguroCalculadoDTO.getNome());
        seguroEntity.setCategoria(seguroCalculadoDTO.getSeguroCategoria());
        seguroEntity.setPrecoBase(seguroCalculadoDTO.getPrecoBase());
        seguroEntity.setPrecoTarifado(seguroCalculadoDTO.getPrecoTarifado());
        seguroEntity.setDataInclusao(dataInclusacao);
        seguroEntity.setDataAlteracao(dataAlteracao);
        return seguroEntity;
    }

    public SeguroCalculadoDTO converterEntityToDTO(SeguroEntity seguroEntity) {
        log.info("Convertendo retorno da Busca do Seguro");
        var seguroCalculadoDTO = new SeguroCalculadoDTO();

        seguroCalculadoDTO.setId(seguroEntity.getId());
        seguroCalculadoDTO.setNome(seguroEntity.getNome());
        seguroCalculadoDTO.setSeguroCategoria(seguroEntity.getCategoria());
        seguroCalculadoDTO.setPrecoBase(seguroEntity.getPrecoBase());
        seguroCalculadoDTO.setPrecoTarifado(seguroEntity.getPrecoTarifado());

        return seguroCalculadoDTO;

    }
}
