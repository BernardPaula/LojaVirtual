package com.bernardpaula.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.CarrinhoDeCompras;

@Repository
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompras, Integer>{

}
