package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarSeguroTest {
    @Mock
    private SeguroService seguroService;

    @Mock
    private SeguroCalculadoConverter seguroCalculadoConverter;

    @InjectMocks
    private BuscarSeguro buscarSeguro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecutar() {
        String id = "1";
        SeguroEntity seguroEntity = new SeguroEntity();
        SeguroCalculadoDTO seguroCalculadoDTO = new SeguroCalculadoDTO();

        when(seguroService.buscarSeguro(id)).thenReturn(seguroEntity);
        when(seguroCalculadoConverter.converterEntityToDTO(seguroEntity)).thenReturn(seguroCalculadoDTO);

        SeguroCalculadoDTO resultado = buscarSeguro.executar(id);

        assertEquals(seguroCalculadoDTO, resultado);

        verify(seguroService, times(1)).buscarSeguro(id);
        verify(seguroCalculadoConverter, times(1)).converterEntityToDTO(seguroEntity);
    }
}
