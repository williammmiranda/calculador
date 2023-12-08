package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroEntityToSeguroCalculadoTOConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscarSeguro {
    private final SeguroService seguroService;
    private final SeguroEntityToSeguroCalculadoTOConverter seguroEntityToSeguroCalculadoTOConverter;

    public SeguroCalculadoDTO executar(String id) {

        var seguroEntity = buscarSeguro(id);

        return converterSeguroEntityParaCalculadoTO(seguroEntity);
    }

    private SeguroEntity buscarSeguro(String id) {
        return seguroService.buscarSeguro(id);
    }

    private SeguroCalculadoDTO converterSeguroEntityParaCalculadoTO(SeguroEntity seguroEntity) {
        return seguroEntityToSeguroCalculadoTOConverter.convert(seguroEntity);
    }
}