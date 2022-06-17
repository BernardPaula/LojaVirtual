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

import com.bernardpaula.lojavirtual.domain.InformacaoDeEnvio;
import com.bernardpaula.lojavirtual.service.InformacaoDeEnvioService;

@RestController
@RequestMapping(value="/informacoesdeenvios")
public class InformacaoDeEnvioResource {

	@Autowired
	private InformacaoDeEnvioService service;
	
	
	@RequestMapping(value="/buscar/{id}", method=RequestMethod.GET)
	public ResponseEntity<InformacaoDeEnvio> find( @PathVariable Integer id ){
		InformacaoDeEnvio obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<InformacaoDeEnvio>> findAll(  ){
		List<InformacaoDeEnvio> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/inserir", method=RequestMethod.POST)
	public ResponseEntity<InformacaoDeEnvio> insert(@RequestBody InformacaoDeEnvio obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/atualizar", method=RequestMethod.PUT)
	public ResponseEntity<InformacaoDeEnvio> update(@RequestBody InformacaoDeEnvio obj){
		InformacaoDeEnvio newObj = service.update(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<InformacaoDeEnvio>> findPage(
			@RequestParam(value= "page", defaultValue = "0")Integer page, 
			@RequestParam(value= "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value= "orderBy", defaultValue = "tipoEnvio")String orderBy, 
			@RequestParam(value= "direction", defaultValue = "ASC")String direction){
		Page<InformacaoDeEnvio> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<InformacaoDeEnvio>> filtrarTipoEnvio(@PathVariable String pesquisa){
		List<InformacaoDeEnvio> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
