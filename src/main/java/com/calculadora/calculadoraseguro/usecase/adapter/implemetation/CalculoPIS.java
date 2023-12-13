package com.calculadora.calculadoraseguro.usecase.adapter.implemetation;

import com.calculadora.calculadoraseguro.usecase.adapter.Calculo;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CalculoPIS implements Calculo {
    private BigDecimal taxaPIS;

    public CalculoPIS(BigDecimal taxaPIS) {
        this.taxaPIS = taxaPIS;
    }

    @Override
    public BigDecimal calcular(BigDecimal precoBase) {
        log.info("Calcular o Preço do PIS do Seguro");
        return precoBase.multiply(taxaPIS);
    }
}