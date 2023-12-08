package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.adapters.Calculo;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraPreco {
    private Calculo[] impostos;

    public CalculadoraPreco(Calculo... impostos) {
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