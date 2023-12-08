package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.adapters.implemetation.CalculoCOFINS;
import com.calculadora.calculadoraseguro.adapters.implemetation.CalculoIOF;
import com.calculadora.calculadoraseguro.adapters.implemetation.CalculoPIS;
import com.calculadora.calculadoraseguro.domain.Seguro;
import org.springframework.stereotype.Service;

@Service
public class CriarSeguro {

    public double executar(Double precoBase, Seguro seguro) {
        CalcularPreco calculadora = new CalcularPreco(
                new CalculoIOF(seguro.getIof()),
                new CalculoPIS(seguro.getPis()),
                new CalculoCOFINS(seguro.getCofins())
        );

        return calculadora.calcularPrecoFinal(precoBase);
    }
}