package com.calculadora.calculadoraseguro.usecase.adapter.implemetation;

import com.calculadora.calculadoraseguro.usecase.adapter.Calculo;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CalculoCOFINS implements Calculo {
    private final BigDecimal taxaCONFINS;

    public CalculoCOFINS(BigDecimal taxaCONFINS) {
        this.taxaCONFINS = taxaCONFINS;
    }

    @Override
    public BigDecimal calcular(BigDecimal precoBase) {
        log.info("Calcular o Preço do CONFINNS do Seguro");
        return precoBase.multiply(taxaCONFINS);
    }
}