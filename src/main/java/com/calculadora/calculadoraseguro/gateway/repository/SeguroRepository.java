package com.calculadora.calculadoraseguro.gateway.repository;

import com.calculadora.calculadoraseguro.gateway.entity.SeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroEntity, String> {

}