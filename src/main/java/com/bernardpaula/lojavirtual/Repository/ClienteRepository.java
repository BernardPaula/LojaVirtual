package com.bernardpaula.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "SELECT * FROM cliente WHERE nome_cliente LIKE %:pesquisa%", nativeQuery = true)
	List<Cliente> filtrar (@Param("pesquisa") String pesquisa);
	
}
