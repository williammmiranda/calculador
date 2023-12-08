package com.calculadora.calculadoraseguro.http;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguroService {
    private final SeguroRepository seguroRepository;

    @Autowired
    public SeguroService(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }

    public SeguroEntity salvarSeguro(SeguroEntity seguro) {
        return seguroRepository.save(seguro);
    }

}
