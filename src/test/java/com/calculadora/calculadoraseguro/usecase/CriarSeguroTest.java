package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroTO;
import com.calculadora.calculadoraseguro.usecase.CalcularPrecoSeguro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriarSeguroTest {

    @Mock
    private SeguroCalculadoConverter seguroCalculadoConverter;

    @Mock
    private SeguroService seguroService;

    @Mock
    private CalcularPrecoSeguro calcularPrecoSeguro;

    @InjectMocks
    private CriarSeguro criarSeguro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecutar() {
        SeguroTO seguroTO = criarSeguroTO();
        SeguroCalculadoDTO seguroCalculadoDTO = criarSeguroCalculadoDTO();
        SeguroEntity seguroEntity = new SeguroEntity();

        when(calcularPrecoSeguro.executar(seguroTO.getPrecoBase(), seguroTO.getSeguroCategoria()))
                .thenReturn(seguroTO.getPrecoBase().multiply(BigDecimal.valueOf(1.1)));

        when(seguroCalculadoConverter.convertDTOtoEntity(any())).thenReturn(seguroEntity);
        when(seguroService.salvarSeguro(any())).thenReturn(seguroEntity);
        when(seguroCalculadoConverter.converterEntityToDTO(any())).thenReturn(seguroCalculadoDTO);

        SeguroCalculadoDTO resultado = criarSeguro.executar(seguroTO);

        assertEquals(seguroCalculadoDTO, resultado);

        verify(calcularPrecoSeguro, times(1)).executar(any(), any());
        verify(seguroCalculadoConverter, times(1)).convertDTOtoEntity(any());
        verify(seguroService, times(1)).salvarSeguro(any());
        verify(seguroCalculadoConverter, times(1)).converterEntityToDTO(any());
    }

    private static SeguroTO criarSeguroTO() {
        SeguroTO seguroTO = new SeguroTO();
        seguroTO.setNome("Seguro de Teste");
        seguroTO.setSeguroCategoria(SeguroCategoria.AUTO);
        seguroTO.setPrecoBase(BigDecimal.valueOf(100.0));
        return seguroTO;
    }

    private static SeguroCalculadoDTO criarSeguroCalculadoDTO() {
        SeguroCalculadoDTO seguroCalculadoDTO = new SeguroCalculadoDTO();
        seguroCalculadoDTO.setNome("Seguro de Teste");
        seguroCalculadoDTO.setSeguroCategoria(SeguroCategoria.AUTO);
        seguroCalculadoDTO.setPrecoBase(BigDecimal.valueOf(100.0));
        seguroCalculadoDTO.setPrecoTarifado(BigDecimal.valueOf(110.0));
        return seguroCalculadoDTO;
    }
}

