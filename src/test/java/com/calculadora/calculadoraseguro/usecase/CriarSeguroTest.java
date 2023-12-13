package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroDTO;
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
        SeguroDTO seguroDTO = criarSeguroTO();
        SeguroCalculadoDTO seguroCalculadoDTO = criarSeguroCalculadoDTO();
        SeguroEntity seguroEntity = new SeguroEntity();

        when(calcularPrecoSeguro.executar(seguroDTO.getPrecoBase(), seguroDTO.getSeguroCategoria()))
                .thenReturn(seguroDTO.getPrecoBase().multiply(BigDecimal.valueOf(1.1)));

        when(seguroCalculadoConverter.convertDTOtoEntity(any(), any(), any())).thenReturn(seguroEntity);
        when(seguroService.salvarSeguro(any())).thenReturn(seguroEntity);
        when(seguroCalculadoConverter.converterEntityToDTO(any())).thenReturn(seguroCalculadoDTO);

        SeguroCalculadoDTO resultado = criarSeguro.executar(seguroDTO);

        assertEquals(seguroCalculadoDTO, resultado);

        verify(calcularPrecoSeguro, times(1)).executar(any(), any());
        verify(seguroCalculadoConverter, times(1)).convertDTOtoEntity(any(), any(), any());
        verify(seguroService, times(1)).salvarSeguro(any());
        verify(seguroCalculadoConverter, times(1)).converterEntityToDTO(any());
    }

    private static SeguroDTO criarSeguroTO() {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNome("Seguro de Teste");
        seguroDTO.setSeguroCategoria(SeguroCategoria.AUTO);
        seguroDTO.setPrecoBase(BigDecimal.valueOf(100.0));
        return seguroDTO;
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

