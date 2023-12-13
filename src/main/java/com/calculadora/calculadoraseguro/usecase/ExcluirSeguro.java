package com.calculadora.calculadoraseguro.usecase;


import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExcluirSeguro {
    private final SeguroService seguroService;

    public void executar(String id) {
        seguroService.buscarSeguro(id);
        seguroService.excluirSeguro(id);
    }
}