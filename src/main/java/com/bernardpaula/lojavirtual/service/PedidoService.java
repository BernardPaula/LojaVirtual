package com.bernardpaula.lojavirtual.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bernardpaula.lojavirtual.domain.Pedido;
import com.bernardpaula.lojavirtual.repository.PedidoRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + Pedido.class.getName()));
	}
	
	public List<Pedido> findAll() {
		return repo.findAll();
	}
	
	public Pedido insert(Pedido obj) {
		try {
		obj.setDataCriacao(new Date());	
		repo.save(obj);
		return find(obj.getNumPedido());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Pedido update(Pedido obj) {	
		Pedido newObj = find(obj.getNumPedido());
		obj.setDataCriacao(newObj.getDataCriacao());
		newObj = repo.save(obj);
		return newObj;
	}
	
	public void delete(Integer id) {
		try {
			Pedido obj = find(id);
			if(obj != null) {
				repo.delete(obj);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Pedido");
		}
	}
	
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Pedido> filtrar(String pesquisa){
		List<Pedido> list = repo.filtrar(pesquisa);
		return list;
	}
}
