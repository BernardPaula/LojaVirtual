package com.bernardpaula.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.lojavirtual.domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	@Query(value="SELECT * FROM administrador WHERE nomeAdmin LIKE %:pesquisa%", nativeQuery=true)
	List<Administrador> filtrar(@Param("pesquisa")String pesquisa);
	
}
