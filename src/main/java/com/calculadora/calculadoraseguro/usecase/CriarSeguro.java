package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoTOToSeguroEntityConverter;
import com.calculadora.calculadoraseguro.gateway.converter.SeguroEntityToSeguroCalculadoTOConverter;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarSeguro {
    private SeguroEntityToSeguroCalculadoTOConverter seguroEntityToSeguroCalculadoTOConverter;
    private SeguroCalculadoTOToSeguroEntityConverter seguroCalculadoTOToSeguroEntityConverter;
    private SeguroService seguroService;
    private CalcularPrecoSeguro calcularPrecoSeguro;

    public SeguroCalculadoTO executar(SeguroTO seguroTO) {
        var seguroCalculadoTO = new SeguroCalculadoTO();
        seguroCalculadoTO.setNome(seguroTO.getNome());
        seguroCalculadoTO.setPrecoBase(seguroTO.getPrecoBase());
        seguroCalculadoTO.setSeguroCategoria(seguroTO.getSeguroCategoria());
        seguroCalculadoTO.setPrecoTarifado(calcularPrecoSeguro.executar(seguroTO.getPrecoBase(), seguroTO.getSeguroCategoria()));

        var seguroEntity = seguroService.salvarSeguro(seguroCalculadoTOToSeguroEntityConverter.convert(seguroCalculadoTO));

        return seguroEntityToSeguroCalculadoTOConverter.convert(seguroEntity);
    }
}