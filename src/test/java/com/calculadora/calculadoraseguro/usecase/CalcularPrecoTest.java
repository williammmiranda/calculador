package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.usecase.adapter.Calculo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalcularPrecoTest {

    @Test
    public void testCalcularPrecoFinal() {
        Calculo calculo1 = mock(Calculo.class);
        Calculo calculo2 = mock(Calculo.class);

        when(calculo1.calcular(BigDecimal.valueOf(100))).thenReturn(BigDecimal.valueOf(10));
        when(calculo2.calcular(BigDecimal.valueOf(100))).thenReturn(BigDecimal.valueOf(20));

        CalcularPreco calcularPreco = new CalcularPreco(calculo1, calculo2);

        BigDecimal precoFinal = calcularPreco.calcularPrecoFinal(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(130), precoFinal);
    }
}
