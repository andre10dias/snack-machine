package com.arquitetura.orientada.servicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitetura.orientada.servicos.domain.Maquina;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {

}
