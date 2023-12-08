package com.calculadora.calculadoraseguro.adapters.implemetation;

import com.calculadora.calculadoraseguro.adapters.Calculo;

public class CalculoIOF implements Calculo {

    private double taxaIOF;

    public CalculoIOF(Double taxaIOF) {
        this.taxaIOF = taxaIOF;
    }

    @Override
    public Double calcular(Double precoBase) {
        return precoBase * taxaIOF;
    }
}