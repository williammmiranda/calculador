package com.calculadora.calculadoraseguro.usecase.adapter.implmetation;

import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoIOF;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoIOFTest {

    @Test
    public void testCalcular() {
        BigDecimal taxaIOF = new BigDecimal("0.05");
        BigDecimal precoBase = new BigDecimal("100");
        BigDecimal resultadoEsperado = new BigDecimal("5.00");

        CalculoIOF calculoIOF = new CalculoIOF(taxaIOF);

        BigDecimal resultadoCalculado = calculoIOF.calcular(precoBase);

        assertEquals(resultadoEsperado, resultadoCalculado);
    }
}