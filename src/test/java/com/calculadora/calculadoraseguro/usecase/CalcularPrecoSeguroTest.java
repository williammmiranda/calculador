package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.usecase.adapters.Calculo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class CalcularPrecoSeguroTest {

    @Test
    void testCalcularPrecoFinalSemImpostos() {
        CalcularPreco calcularPreco = new CalcularPreco();
        BigDecimal precoFinal = calcularPreco.calcularPrecoFinal(BigDecimal.valueOf(50));
       // assertEquals(BigDecimal.valueOf(50), precoFinal, BigDecimal.valueOf(0.01));
    }

    @Test
    void testCalcularPrecoFinalComImpostos() {
        Calculo imposto1 = mock(Calculo.class);
        Calculo imposto2 = mock(Calculo.class);

        when(imposto1.calcular(any())).thenReturn(BigDecimal.valueOf(5));
        when(imposto2.calcular(any())).thenReturn(BigDecimal.valueOf(8));

        CalcularPreco calcularPreco = new CalcularPreco(imposto1, imposto2);
        BigDecimal precoFinal = calcularPreco.calcularPrecoFinal(BigDecimal.valueOf(50));

        verify(imposto1).calcular(BigDecimal.valueOf(50));
        verify(imposto2).calcular(BigDecimal.valueOf(55));

        //assertEquals(BigDecimal.valueOf(63), precoFinal, 0.01);
    }

    @Test
    void testCalcularPrecoFinalComImpostoNulo() {
        Calculo imposto1 = mock(Calculo.class);

        when(imposto1.calcular(any())).thenReturn(BigDecimal.valueOf(5));

        CalcularPreco calcularPreco = new CalcularPreco(imposto1, null);
        BigDecimal precoFinal = calcularPreco.calcularPrecoFinal(BigDecimal.valueOf(50));

        verify(imposto1).calcular(BigDecimal.valueOf(50));

        //assertEquals(55.0, precoFinal, 0.01);
    }
}