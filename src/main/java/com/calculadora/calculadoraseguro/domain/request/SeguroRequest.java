package com.calculadora.calculadoraseguro.domain.request;

import com.calculadora.calculadoraseguro.domain.Seguro;
import lombok.Data;

@Data
public class SeguroRequest {
    private String nome;

    private Seguro categoria;
    private Double precoBase;
}
