package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.exception.PrecoBaseException;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoCOFINS;
import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoIOF;
import com.calculadora.calculadoraseguro.usecase.adapter.implemetation.CalculoPIS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CalcularPrecoSeguroTest {

    @Mock
    private CalculoIOF calculoIOF;

    @Mock
    private CalculoPIS calculoPIS;

    @Mock
    private CalculoCOFINS calculoCOFINS;

    @InjectMocks
    private CalcularPrecoSeguro calcularPrecoSeguro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecutarComPrecoBaseNulo() {
        CalcularPrecoSeguro calcularPrecoSeguro = new CalcularPrecoSeguro();

        assertThrows(PrecoBaseException.class, () -> calcularPrecoSeguro.executar(null, SeguroCategoria.VIDA));
    }

    @ParameterizedTest
    @EnumSource(SeguroCategoria.class)
    void testExecutarComPrecoBaseValido(SeguroCategoria categoria) {

        when(calculoIOF.calcular(any(BigDecimal.class))).thenReturn(categoria.getIof());
        when(calculoPIS.calcular(any(BigDecimal.class))).thenReturn(categoria.getPis());
        when(calculoCOFINS.calcular(any(BigDecimal.class))).thenReturn(categoria.getCofins());

        BigDecimal precoBase = BigDecimal.valueOf(100.0);
        BigDecimal precoFinal = calcularPrecoSeguro.executar(precoBase, categoria);

        BigDecimal expectedPrecoFinal = precoBase.multiply(BigDecimal.ONE.add(categoria.getIof()).add(categoria.getPis()).add(categoria.getCofins()));
        assertEquals(expectedPrecoFinal, precoFinal);
    }
}