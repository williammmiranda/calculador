package com.calculadora.calculadoraseguro.http;

import com.calculadora.calculadoraseguro.domain.request.SeguroRequest;
import com.calculadora.calculadoraseguro.usecase.CalcularPrecoSeguro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.calculadora.calculadoraseguro.http.URLMapping.SEGURO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = SEGURO)
@AllArgsConstructor
@Api(tags = "Seguros", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class SeguroWS {

    private final CalcularPrecoSeguro calcularPrecoSeguro;

    @PostMapping
    @ApiOperation(value = "Cria um seguro novo")
    public double criarSeguro(@RequestBody SeguroRequest seguroRequest){
        return calcularPrecoSeguro.executar(seguroRequest.getPrecoBase(), seguroRequest.getCategoria());
    }
}
