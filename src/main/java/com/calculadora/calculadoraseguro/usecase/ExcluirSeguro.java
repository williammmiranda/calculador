package com.calculadora.calculadoraseguro.usecase;


import com.calculadora.calculadoraseguro.gateway.service.SeguroService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ExcluirSeguro {
    private final SeguroService seguroService;

    public void executar(String id) {
        log.info("Entrou na classe Excluir Seguro");
        seguroService.buscarSeguro(id);
        seguroService.excluirSeguro(id);
    }
}