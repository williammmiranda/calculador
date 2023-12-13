package com.calculadora.calculadoraseguro.http.domain;

import com.calculadora.calculadoraseguro.http.domain.utils.BigDecimalSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class SeguroCalculadoDTO extends SeguroDTO {
    @ApiModelProperty(value = "UUID TRansacional", name = "id", dataType = "String", example = "8cfb5eb2-fd93-4322-bb74-c82f27c95a47")
    @JsonProperty("id")
    private String id;

    @ApiModelProperty(value = "Preço do Seguro após tarifas", name = "preco_tarifado", dataType = "Double", example = "106.00")
    @JsonProperty("preco_tarifado")
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal precoTarifado;

}
