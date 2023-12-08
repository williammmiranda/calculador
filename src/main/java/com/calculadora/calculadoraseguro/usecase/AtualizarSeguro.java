package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoTOToSeguroEntityConverter;
import com.calculadora.calculadoraseguro.gateway.converter.SeguroEntityToSeguroCalculadoTOConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarSeguro {
    private final SeguroEntityToSeguroCalculadoTOConverter seguroEntityToSeguroCalculadoTOConverter;
    private final SeguroCalculadoTOToSeguroEntityConverter seguroCalculadoTOToSeguroEntityConverter;
    private final SeguroService seguroService;
    private final CalcularPrecoSeguro calcularPrecoSeguro;
    private final BuscarSeguro buscarSeguro;

    public SeguroCalculadoDTO executar(SeguroTO seguroTO, String id) {
        var buscarSeguroTO = buscarSeguro.executar(id);

        var seguroCalculadoTO = gerarSeguroCalculadoTO(seguroTO, id, buscarSeguroTO);

        var seguroEntity = salvarSeguro(seguroCalculadoTO);

        return converterSeguroEntityParaCalculadoTO(seguroEntity);
    }


    private SeguroCalculadoDTO gerarSeguroCalculadoTO(SeguroTO seguroTO, String id, SeguroCalculadoDTO buscarSeguroTO){
        var seguroCalculadoTO = new SeguroCalculadoDTO();
        preencherSeguroTO(seguroTO, buscarSeguroTO);

        seguroCalculadoTO.setId(id);
        seguroCalculadoTO.setNome(seguroTO.getNome());
        seguroCalculadoTO.setPrecoBase(seguroTO.getPrecoBase());
        seguroCalculadoTO.setSeguroCategoria(seguroTO.getSeguroCategoria());
        seguroCalculadoTO.setPrecoTarifado(calcularPrecoSeguro.executar(seguroTO.getPrecoBase(), seguroTO.getSeguroCategoria()));

        return seguroCalculadoTO;
    }

    private void preencherSeguroTO(SeguroTO seguroTO,  SeguroCalculadoDTO buscarSeguroTO){
        seguroTO.setPrecoBase(seguroTO.getPrecoBase() != null ? seguroTO.getPrecoBase() : buscarSeguroTO.getPrecoBase());
        seguroTO.setSeguroCategoria(seguroTO.getSeguroCategoria() != null ? seguroTO.getSeguroCategoria() : buscarSeguroTO.getSeguroCategoria());
        seguroTO.setNome(seguroTO.getNome() != null ? seguroTO.getNome() : buscarSeguroTO.getNome());
    }

    private SeguroEntity salvarSeguro(SeguroCalculadoDTO seguroCalculadoDTO) {
        return seguroService.salvarSeguro(seguroCalculadoTOToSeguroEntityConverter.convert(seguroCalculadoDTO));
    }

    private SeguroCalculadoDTO converterSeguroEntityParaCalculadoTO(SeguroEntity seguroEntity) {
        return seguroEntityToSeguroCalculadoTOConverter.convert(seguroEntity);
    }
}