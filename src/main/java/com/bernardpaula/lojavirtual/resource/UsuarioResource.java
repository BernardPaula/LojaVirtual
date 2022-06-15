package com.bernardpaula.lojavirtual.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardpaula.lojavirtual.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	/*
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public ResponseEntity<>> find(  ){
		
	}
	
	@RequestMapping(value="/inserir", method=RequestMethod.POST)
	public ResponseEntity<> inserir(  ){
		
	}
	
	@RequestMapping(value="/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<> update(  ){
		
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<> delete(  ){
		
	}
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<> findPage(  ){
		
	}
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<> filtrar(  ){
		
	}*/
	
}
