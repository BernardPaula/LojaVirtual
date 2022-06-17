package com.bernardpaula.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query(value = "SELECT * FROM pedido WHERE nome_cliente LIKE %:pesquisa%", nativeQuery=true)
	List<Pedido> filtrar(@Param("pesquisa") String pesquisa);
	
}
