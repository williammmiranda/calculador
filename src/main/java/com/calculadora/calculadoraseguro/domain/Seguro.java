package com.calculadora.calculadoraseguro.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Seguro {
    VIDA(0.01,0.022, 0.0),
    AUTO(0.055, 0.04, 0.01),
    VIAGEM(0.02, 0.04, 0.01),
    RESIDENCIAL(0.04, 0.0, 0.01),
    PATRIMONIAL(0.05, 0.03,0.0);

    private final Double iof;
    private final Double pis;
    private final Double cofins;

}