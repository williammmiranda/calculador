package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.adapters.implemetation.CalculoCOFINS;
import com.calculadora.calculadoraseguro.adapters.implemetation.CalculoIOF;
import com.calculadora.calculadoraseguro.adapters.implemetation.CalculoPIS;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import org.springframework.stereotype.Service;

@Service
public class CalcularPrecoSeguro {

    public double executar(Double precoBase, SeguroCategoria seguro) {
        CalcularPreco calculadora = new CalcularPreco(
                new CalculoIOF(seguro.getIof()),
                new CalculoPIS(seguro.getPis()),
                new CalculoCOFINS(seguro.getCofins())
        );

        return calculadora.calcularPrecoFinal(precoBase);
    }
}