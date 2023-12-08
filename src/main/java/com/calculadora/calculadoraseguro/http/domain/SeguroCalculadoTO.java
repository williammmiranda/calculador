package com.calculadora.calculadoraseguro.http.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeguroCalculadoTO extends SeguroTO{
    @ApiModelProperty(value = "UUID TRansacional", name = "id", dataType = "String", example = "8cfb5eb2-fd93-4322-bb74-c82f27c95a47")
    @JsonAlias("id")
    private String id;

    @ApiModelProperty(value = "Preço do Seguro após tarifas", name = "preco_tarifado", dataType = "Double", example = "106.00")
    @JsonAlias("preco_tarifado")
    private Double precoTarifado;
}
