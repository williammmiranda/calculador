package com.calculadora.calculadoraseguro.http;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroCategoria;
import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import com.calculadora.calculadoraseguro.gateway.repository.SeguroRepository;
import com.calculadora.calculadoraseguro.http.domain.SeguroCalculadoDTO;
import com.calculadora.calculadoraseguro.http.domain.SeguroDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeguroWSTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private SeguroRepository repository;

    SeguroEntity seguroEntity;

    @BeforeAll
    public void iniciar() {
        this.seguroEntity = new SeguroEntity();
        seguroEntity.setNome("Seguro de Vida Individual");
        seguroEntity.setCategoria(SeguroCategoria.VIDA);
        seguroEntity.setPrecoBase(new BigDecimal("100"));
        seguroEntity.setPrecoTarifado(new BigDecimal("103.20"));
    }

    @Test
    public void criarNovoSeguroTest() {

        var seguroDTO = criarSeguroDTO();

        HttpEntity<SeguroDTO> httpEntity = new HttpEntity<>(seguroDTO);

        ResponseEntity<SeguroCalculadoDTO> response = this.testRestTemplate
                .exchange("/api/seguro", HttpMethod.POST, httpEntity, SeguroCalculadoDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getPrecoTarifado(), new BigDecimal("103.20"));
        assertNotNull(response.getBody().getId());

        this.repository.deleteById(response.getBody().getId());
    }

    @Test
    public void buscarSeguroPorIdTest() {
        SeguroEntity seguroEntity = this.repository.save(this.seguroEntity);

        ResponseEntity<SeguroCalculadoDTO> response = this.testRestTemplate
                .exchange("/api/seguro/" + seguroEntity.getId(), HttpMethod.GET, null, SeguroCalculadoDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody().getId());
        assertEquals(response.getBody().getNome(), "Seguro de Vida Individual");
        assertEquals(response.getBody().getSeguroCategoria(), SeguroCategoria.VIDA);
        assertEquals(response.getBody().getPrecoBase(), new BigDecimal("100.00"));
        assertEquals(response.getBody().getPrecoTarifado(), new BigDecimal("103.20"));

        this.repository.deleteById(seguroEntity.getId());
    }

    @Test
    public void alterarSeguroTest() {

        SeguroEntity seguroEntity = this.repository.save(this.seguroEntity);

        var seguroDTO = criarSeguroDTO();
        seguroDTO.setSeguroCategoria(SeguroCategoria.AUTO);

        HttpEntity<SeguroDTO> httpEntity = new HttpEntity<>(seguroDTO);

        ResponseEntity<SeguroCalculadoDTO> response = this.testRestTemplate
                .exchange("/api/seguro/" + seguroEntity.getId(), HttpMethod.PUT, httpEntity, SeguroCalculadoDTO.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody().getId());
        assertEquals(response.getBody().getNome(), "Seguro de Vida Individual");
        assertEquals(response.getBody().getSeguroCategoria(), SeguroCategoria.AUTO);
        assertEquals(response.getBody().getPrecoBase(), new BigDecimal("100.00"));
        assertEquals(response.getBody().getPrecoTarifado(), new BigDecimal("110.50"));

        this.repository.deleteById(seguroEntity.getId());
    }

    @Test
    public void removerSeguroTest() {

        SeguroEntity seguroEntity = this.repository.save(this.seguroEntity);

        ResponseEntity<Void> response = this.testRestTemplate
                .exchange("/api/seguro/" + seguroEntity.getId(), HttpMethod.DELETE, null, Void.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    private SeguroDTO criarSeguroDTO(){
        var seguroDTO = new SeguroDTO();

        seguroDTO.setNome("Seguro de Vida Individual");
        seguroDTO.setSeguroCategoria(SeguroCategoria.VIDA);
        seguroDTO.setPrecoBase(new BigDecimal("100"));

        return seguroDTO;
    }
}