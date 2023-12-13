package com.calculadora.calculadoraseguro.gateway.service;

import com.calculadora.calculadoraseguro.exception.SeguroNotFoundException;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.repository.SeguroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeguroService {
    private final SeguroRepository seguroRepository;

    public SeguroEntity salvarSeguro(SeguroEntity seguro) {
        return seguroRepository.save(seguro);
    }

    public SeguroEntity buscarSeguro(String id) {
        return seguroRepository.findById(id)
                .orElseThrow(() -> new SeguroNotFoundException("Seguro não encontrado com o ID: " + id));
    }

    public void excluirSeguro(String id) {
        seguroRepository.deleteById(id);
    }

}
