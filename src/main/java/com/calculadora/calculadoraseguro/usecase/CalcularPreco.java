package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.adapters.Calculo;

public class CalcularPreco {
    private Calculo[] impostos;

    public CalcularPreco(Calculo... impostos) {
        this.impostos = impostos;
    }

    public double calcularPrecoFinal(double precoBase) {
        double precoFinal = precoBase;

        for (Calculo imposto : impostos) {
            precoFinal += imposto.calcular(precoBase);
        }

        return precoFinal;
    }
}