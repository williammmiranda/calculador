package com.calculadora.calculadoraseguro.http;

import com.calculadora.calculadoraseguro.http.domain.SeguroTO;
import com.calculadora.calculadoraseguro.usecase.AtualizarSeguro;
import com.calculadora.calculadoraseguro.usecase.BuscarSeguro;
import com.calculadora.calculadoraseguro.usecase.CriarSeguro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.calculadora.calculadoraseguro.http.URLMapping.SEGURO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = SEGURO)
@AllArgsConstructor
@Api(tags = "Seguros", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class SeguroWS {

    private final CriarSeguro criarSeguro;
    private final BuscarSeguro buscarSeguro;
    private final AtualizarSeguro atualizarSeguro;

    @PostMapping
    @ApiOperation(value = "Cria um seguro novo")
    public ResponseEntity<?> criarSeguro(@RequestBody SeguroTO seguroRequest){
        return ResponseEntity.ok().body(criarSeguro.executar(seguroRequest));
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar Seguro pelo id")
    public ResponseEntity<?>  buscarSeguroPorId(@PathVariable String id){
        return ResponseEntity.ok().body(buscarSeguro.executar(id));
    }


    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza informações de um seguro")
    public ResponseEntity<?> atualizarSeguro(@PathVariable String id,
                                             @RequestBody SeguroTO seguroRequest){
        return ResponseEntity.ok().body(atualizarSeguro.executar(seguroRequest, id));
    }

}
