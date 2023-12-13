package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.converter.SeguroCalculadoConverter;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
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

class AtualizarSeguroTest {

    @Mock
    private SeguroService seguroService;

    @Mock
    private SeguroCalculadoConverter seguroCalculadoConverter;

    @Mock
    private CalcularPrecoSeguro calcularPrecoSeguro;

    @InjectMocks
    private AtualizarSeguro atualizarSeguro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testExecutar() {
        String id = "1";
        SeguroDTO seguroDTO = criarSeguroTO();
        SeguroEntity seguroEntity = criarSeguroEntity();
        SeguroCalculadoDTO seguroCalculadoDTO = criarSeguroCalculadoDTO();

        when(seguroService.buscarSeguro(id)).thenReturn(seguroEntity);
        when(seguroCalculadoConverter.converterEntityToDTO(seguroEntity)).thenReturn(seguroCalculadoDTO);
        when(calcularPrecoSeguro.executar(any(), any())).thenReturn(BigDecimal.TEN);

        SeguroCalculadoDTO resultado = atualizarSeguro.executar(seguroDTO, id);

        verify(seguroService, times(1)).buscarSeguro(id);
        verify(seguroCalculadoConverter, times(1)).converterEntityToDTO(seguroEntity);
        verify(calcularPrecoSeguro, times(1)).executar(any(), any());

    }

    @Test
    void testExecutarParmetrosEntradaNulos() {
        String id = "1";
        SeguroDTO seguroDTO = new SeguroDTO();
        SeguroEntity seguroEntity = criarSeguroEntity();
        SeguroCalculadoDTO seguroCalculadoDTO = criarSeguroCalculadoDTO();

        when(seguroService.buscarSeguro(id)).thenReturn(seguroEntity);
        when(seguroCalculadoConverter.converterEntityToDTO(seguroEntity)).thenReturn(seguroCalculadoDTO);
        when(calcularPrecoSeguro.executar(any(), any())).thenReturn(BigDecimal.TEN);

        SeguroCalculadoDTO resultado = atualizarSeguro.executar(seguroDTO, id);

        verify(seguroService, times(1)).buscarSeguro(id);
        verify(seguroCalculadoConverter, times(1)).converterEntityToDTO(seguroEntity);
        verify(calcularPrecoSeguro, times(1)).executar(any(), any());

    }

    private SeguroDTO criarSeguroTO() {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNome("Seguro de Teste");
        seguroDTO.setSeguroCategoria(SeguroCategoria.AUTO);
        seguroDTO.setPrecoBase(BigDecimal.valueOf(100.0));
        return seguroDTO;
    }

    private SeguroEntity criarSeguroEntity() {
        SeguroEntity seguroEntity = new SeguroEntity();
        seguroEntity.setId("1");
        seguroEntity.setNome("Seguro de Teste");
        seguroEntity.setCategoria(SeguroCategoria.AUTO);
        seguroEntity.setPrecoBase(BigDecimal.valueOf(100.0));
        seguroEntity.setPrecoTarifado(BigDecimal.valueOf(110.5));
        return seguroEntity;
    }

    private SeguroCalculadoDTO criarSeguroCalculadoDTO() {
        SeguroCalculadoDTO seguroCalculadoDTO = new SeguroCalculadoDTO();
        seguroCalculadoDTO.setId("1");
        seguroCalculadoDTO.setNome("Seguro de Teste");
        seguroCalculadoDTO.setSeguroCategoria(SeguroCategoria.AUTO);
        seguroCalculadoDTO.setPrecoBase(BigDecimal.valueOf(100.0));
        seguroCalculadoDTO.setPrecoTarifado(BigDecimal.valueOf(110.5));
        return seguroCalculadoDTO;
    }
}

