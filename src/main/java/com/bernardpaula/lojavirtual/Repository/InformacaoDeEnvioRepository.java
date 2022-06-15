package com.bernardpaula.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.InformacaoDeEnvio;

@Repository
public interface InformacaoDeEnvioRepository extends JpaRepository<InformacaoDeEnvio, Integer>{

}
