package com.calculadora.calculadoraseguro.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum SeguroCategoria {
    VIDA(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.022), BigDecimal.ZERO),
    AUTO(BigDecimal.valueOf(0.055), BigDecimal.valueOf(0.04), BigDecimal.valueOf(0.01)),
    VIAGEM(BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.04), BigDecimal.valueOf(0.01)),
    RESIDENCIAL(BigDecimal.valueOf(0.04), BigDecimal.ZERO, BigDecimal.valueOf(0.01)),
    PATRIMONIAL(BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.03), BigDecimal.ZERO);


    private final BigDecimal iof;
    private final BigDecimal pis;
    private final BigDecimal cofins;

}