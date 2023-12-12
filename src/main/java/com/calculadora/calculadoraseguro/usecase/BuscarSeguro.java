package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscarSeguro {
    private final SeguroService seguroService;
    private final SeguroCalculadoConverter seguroCalculadoConverter;

    public SeguroCalculadoDTO executar(String id) {
        SeguroEntity seguroEntity = seguroService.buscarSeguro(id);

        return converterParaDTO(seguroEntity);
    }

    private SeguroCalculadoDTO converterParaDTO(SeguroEntity seguroEntity) {
        return seguroCalculadoConverter.converterEntityToDTO(seguroEntity);
    }
}