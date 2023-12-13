package com.calculadora.calculadoraseguro.usecase;

import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ExcluirSeguroTest {

    @Mock
    private SeguroService seguroService;

    @InjectMocks
    private ExcluirSeguro excluirSeguro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecutar() {
        String id = "123";

        excluirSeguro.executar(id);

        Mockito.verify(seguroService, Mockito.times(1)).buscarSeguro(id);
        Mockito.verify(seguroService, Mockito.times(1)).excluirSeguro(id);
    }
}