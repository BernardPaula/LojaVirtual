package com.bernardpaula.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.DetalhesDoPedido;

@Repository
public interface DetalhesDoPedidoRepository extends JpaRepository<DetalhesDoPedido, Integer>{

}
