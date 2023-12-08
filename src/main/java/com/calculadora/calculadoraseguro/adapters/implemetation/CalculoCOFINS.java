package com.calculadora.calculadoraseguro.adapters.implemetation;

import com.calculadora.calculadoraseguro.adapters.Calculo;

public class CalculoCOFINS implements Calculo {
    private final double taxaCOFINS;

    public CalculoCOFINS(Double taxaCOFINS) {
        this.taxaCOFINS = taxaCOFINS;
    }

    @Override
    public Double calcular(Double precoBase) {
        return precoBase * taxaCOFINS;
    }
}