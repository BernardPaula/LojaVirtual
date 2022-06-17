package com.bernardpaula.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.DetalhesDoPedido;

@Repository
public interface DetalhesDoPedidoRepository extends JpaRepository<DetalhesDoPedido, Integer>{

	@Query(value = "SELECT * FROM detalhes_do_pedido WHERE nome_produto LIKE %:pesquisa%", nativeQuery=true)
	List<DetalhesDoPedido> filtrar(@Param("pesquisa") String pesquisa);
	
}
