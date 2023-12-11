package com.calculadora.calculadoraseguro.usecase.adapters.implemetation;

import com.calculadora.calculadoraseguro.usecase.adapters.Calculo;

import java.math.BigDecimal;


public class CalculoCOFINS implements Calculo {
    private final BigDecimal taxaCOFINS;

    public CalculoCOFINS(BigDecimal taxaCOFINS) {
        this.taxaCOFINS = taxaCOFINS;
    }

    @Override
    public BigDecimal calcular(BigDecimal precoBase) {
        return precoBase.multiply(taxaCOFINS);
    }
}