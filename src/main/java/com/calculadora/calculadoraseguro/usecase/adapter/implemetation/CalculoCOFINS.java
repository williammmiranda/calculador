package com.calculadora.calculadoraseguro.usecase.adapter.implemetation;

import com.calculadora.calculadoraseguro.usecase.adapter.Calculo;

import java.math.BigDecimal;


public class CalculoCOFINS implements Calculo {
    private final BigDecimal taxaCONFINS;

    public CalculoCOFINS(BigDecimal taxaCONFINS) {
        this.taxaCONFINS = taxaCONFINS;
    }

    @Override
    public BigDecimal calcular(BigDecimal precoBase) {
        return precoBase.multiply(taxaCONFINS);
    }
}