package com.calculadora.calculadoraseguro.usecase.adapter.implemetation;

import com.calculadora.calculadoraseguro.usecase.adapter.Calculo;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CalculoIOF implements Calculo {

    private BigDecimal taxaIOF;

    public CalculoIOF(BigDecimal taxaIOF) {
        this.taxaIOF = taxaIOF;
    }

    @Override
    public BigDecimal calcular(BigDecimal precoBase) {
        log.info("Calcular o Preço do IOF do Seguro");
        return precoBase.multiply(taxaIOF);
    }
}