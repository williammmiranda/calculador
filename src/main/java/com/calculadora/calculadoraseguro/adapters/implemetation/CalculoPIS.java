package com.calculadora.calculadoraseguro.adapters.implemetation;

import com.calculadora.calculadoraseguro.adapters.Calculo;

public class CalculoPIS implements Calculo {
    private double taxaPIS;

    public CalculoPIS(Double taxaPIS) {
        this.taxaPIS = taxaPIS;
    }

    @Override
    public Double calcular(Double precoBase) {
        return precoBase * taxaPIS;
    }
}