package com.calculadora.calculadoraseguro.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SEGURO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", length = 50, nullable = false)
    private SeguroCategoria categoria;

    @Column(name = "preco_base")
    private BigDecimal precoBase;

    @Column(name = "preco_tarifado")
    private BigDecimal precoTarifado;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao     ;
}
