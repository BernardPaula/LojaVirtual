package com.bernardpaula.lojavirtual.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardpaula.lojavirtual.domain.Administrador;
import com.bernardpaula.lojavirtual.service.AdministradorService;

@RestController
@RequestMapping(value="/administradores")
public class AdministradorResource {

	@Autowired
	private AdministradorService service;
	
	
	@RequestMapping(value="/buscar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Administrador> find(@PathVariable Integer id ){
		Administrador obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Administrador>> findAll(){
		List<Administrador> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/inserir", method=RequestMethod.POST)
	public ResponseEntity<Administrador> insert(@RequestBody Administrador obj ){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/atualizar", method=RequestMethod.PUT)
	public ResponseEntity<Administrador> update(@RequestBody Administrador obj){
		Administrador newObj = service.update(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Administrador>> findPage(
			@RequestParam(value="page", defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nomeAdm")String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")String direction){
		Page<Administrador> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Administrador>> filtrarNome(@PathVariable String pesquisa){
		List<Administrador> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
