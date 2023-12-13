package com.calculadora.calculadoraseguro.http.domain;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import com.calculadora.calculadoraseguro.http.domain.utils.BigDecimalSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class SeguroDTO {
    @ApiModelProperty(value = "Nome do Seguro", name = "nome", dataType = "String", example = "Seguro de Vida Individual")
    @JsonProperty("nome")
    private String nome;

    @ApiModelProperty(value = "Categoria do seguro", name = "categoria", example = "VIDA")
    @JsonProperty("categoria")
    @Enumerated(EnumType.STRING)
    private SeguroCategoria seguroCategoria;

    @ApiModelProperty(value = "Preço do Seguro antes das tarifas", name = "preco_base", dataType = "Double", example = "100.00")
    @JsonProperty("preco_base")
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal precoBase;

}
