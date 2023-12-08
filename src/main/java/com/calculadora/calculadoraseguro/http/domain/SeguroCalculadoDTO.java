package com.calculadora.calculadoraseguro.http.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeguroCalculadoDTO extends SeguroTO{
    @ApiModelProperty(value = "UUID TRansacional", name = "id", dataType = "String", example = "8cfb5eb2-fd93-4322-bb74-c82f27c95a47")
    @JsonProperty("id")
    private String id;

    @ApiModelProperty(value = "Preço do Seguro após tarifas", name = "preco_tarifado", dataType = "Double", example = "106.00")
    @JsonProperty("preco_tarifado")
    private Double precoTarifado;

}
