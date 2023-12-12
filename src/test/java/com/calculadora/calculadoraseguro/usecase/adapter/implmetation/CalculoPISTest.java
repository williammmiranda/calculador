package com.calculadora.calculadoraseguro.usecase.adapter.implmetation;

import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoPIS;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoPISTest {

    @Test
    public void testCalcular() {
        BigDecimal taxaPIS = new BigDecimal("0.05");
        BigDecimal precoBase = new BigDecimal("100");
        BigDecimal resultadoEsperado = new BigDecimal("5.00");
        
        CalculoPIS calculoPIS = new CalculoPIS(taxaPIS);

        BigDecimal resultadoCalculado = calculoPIS.calcular(precoBase);

        assertEquals(resultadoEsperado, resultadoCalculado);
    }
}