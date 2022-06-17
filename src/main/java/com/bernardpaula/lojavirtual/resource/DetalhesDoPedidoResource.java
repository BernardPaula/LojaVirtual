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

import com.bernardpaula.lojavirtual.domain.DetalhesDoPedido;
import com.bernardpaula.lojavirtual.service.DetalhesDoPedidoService;

@RestController
@RequestMapping(value="/detalhesdospedidos")
public class DetalhesDoPedidoResource {

	@Autowired
	private DetalhesDoPedidoService service;
	
	
	@RequestMapping(value="/buscar/{id}", method=RequestMethod.GET)
	public ResponseEntity<DetalhesDoPedido> find( @PathVariable Integer id ){
		DetalhesDoPedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<DetalhesDoPedido>> findAll(  ){
		List<DetalhesDoPedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/inserir", method=RequestMethod.POST)
	public ResponseEntity<DetalhesDoPedido> insert(@RequestBody DetalhesDoPedido obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/atualizar", method=RequestMethod.PUT)
	public ResponseEntity<DetalhesDoPedido> update(@RequestBody DetalhesDoPedido obj){
		DetalhesDoPedido newObj = service.update(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<DetalhesDoPedido>> findPage(
			@RequestParam(value= "page", defaultValue = "0")Integer page, 
			@RequestParam(value= "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value= "orderBy", defaultValue = "nomeProduto")String orderBy, 
			@RequestParam(value= "direction", defaultValue = "ASC")String direction){
		Page<DetalhesDoPedido> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<DetalhesDoPedido>> filtrar(@PathVariable String pesquisa){
		List<DetalhesDoPedido> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
