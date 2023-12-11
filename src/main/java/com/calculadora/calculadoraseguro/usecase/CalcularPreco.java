package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.usecase.adapters.Calculo;

import java.math.BigDecimal;

public class CalcularPreco {
    private Calculo[] impostos;

    public CalcularPreco(Calculo... impostos) {
        this.impostos = impostos;
    }

    public BigDecimal calcularPrecoFinal(BigDecimal precoBase) {
        BigDecimal precoFinal = precoBase;

        for (Calculo imposto : impostos) {
            precoFinal = precoFinal.add(imposto.calcular(precoBase));
        }

        return precoFinal;
    }
}