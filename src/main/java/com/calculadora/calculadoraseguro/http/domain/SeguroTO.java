package com.calculadora.calculadoraseguro.http.domain;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeguroTO {
    @ApiModelProperty(value = "Nome do Seguro", name = "id", dataType = "String", example = "Seguro de Vida Individual")
    @JsonAlias("nome")
    private String nome;

    @ApiModelProperty(value = "Categoria do seguro", name = "categoria", example = "VIDA")
    @JsonAlias("categoria")
    private SeguroCategoria seguroCategoria;

    @ApiModelProperty(value = "Preço do Seguro antes das tarifas", name = "preco_base", dataType = "Double", example = "100.00")
    @JsonAlias("preco_base")
    private Double precoBase;
}
