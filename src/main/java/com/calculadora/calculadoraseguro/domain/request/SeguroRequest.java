package com.calculadora.calculadoraseguro.domain.request;

import com.calculadora.calculadoraseguro.domain.SeguroCategoria;
import lombok.Data;

@Data
public class SeguroRequest {
    private String nome;

    private SeguroCategoria categoria;
    private Double precoBase;
}
