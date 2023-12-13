package com.calculadora.calculadoraseguro.gateway.service;

import com.calculadora.calculadoraseguro.exception.SeguroNotFoundException;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.repository.SeguroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeguroService {
    private final SeguroRepository seguroRepository;

    public SeguroEntity salvarSeguro(SeguroEntity seguro) {
        log.info("Salvar Seguro");
        return seguroRepository.save(seguro);
    }

    public SeguroEntity buscarSeguro(String id) {
        log.info("Buscar Seguro com id: {}", id);
        return seguroRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Seguro não encontrado com o id: {}", id);
                    throw new SeguroNotFoundException("Seguro não encontrado com o id: " + id);
                });
    }

    public void excluirSeguro(String id) {
        log.info("Excluir Seguro com id: {}", id);
        seguroRepository.deleteById(id);
    }

}
