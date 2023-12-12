package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.exception.PrecoBaseException;
import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoCOFINS;
import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoIOF;
import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoPIS;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalcularPrecoSeguro {

    public BigDecimal executar(BigDecimal precoBase, SeguroCategoria seguro) {

        CalcularPreco calculadora = new CalcularPreco(
                new CalculoIOF(seguro.getIof()),
                new CalculoPIS(seguro.getPis()),
                new CalculoCOFINS(seguro.getCofins())
        );

        if(precoBase == null){
            throw new PrecoBaseException("Preço Base não enviado para o calculo");
        }

        return calculadora.calcularPrecoFinal(precoBase);
    }
}