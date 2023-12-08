package com.calculadora.calculadoraseguro.gateway.entity;

import com.calculadora.calculadoraseguro.domain.SeguroCategoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SEGURO")
@Getter
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
    private Double precoBase;

    @Column(name = "preco_tarifado")
    private Double precoTarifado;


}
