package com.calculadora.calculadoraseguro.usecase.adapter.implmetation;

import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoCOFINS;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoCOFINSTest {

    @Test
    public void testCalcular() {
        BigDecimal taxaCOFINS = new BigDecimal("0.05");
        BigDecimal precoBase = new BigDecimal("100");
        BigDecimal resultadoEsperado = new BigDecimal("5.00");

        CalculoCOFINS calculoCOFINS = new CalculoCOFINS(taxaCOFINS);

        BigDecimal resultadoCalculado = calculoCOFINS.calcular(precoBase);

        assertEquals(resultadoEsperado, resultadoCalculado);
    }
}