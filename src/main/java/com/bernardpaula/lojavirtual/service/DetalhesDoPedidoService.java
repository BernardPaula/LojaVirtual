package com.bernardpaula.lojavirtual.service;

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

import com.bernardpaula.lojavirtual.domain.DetalhesDoPedido;
import com.bernardpaula.lojavirtual.repository.DetalhesDoPedidoRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class DetalhesDoPedidoService {

	@Autowired
	private DetalhesDoPedidoRepository repo;
	
	public DetalhesDoPedido find(Integer id) {
		Optional<DetalhesDoPedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + DetalhesDoPedido.class.getName()));
	}
	
	public List<DetalhesDoPedido> findAll() {
		return repo.findAll();
	}
	
	public DetalhesDoPedido insert(DetalhesDoPedido obj) {
		try {
		obj = repo.save(obj);
		return find(obj.getNumPedido());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public DetalhesDoPedido update(DetalhesDoPedido obj) {
		DetalhesDoPedido newObj = find(obj.getNumPedido());
		newObj = repo.save(obj);
		return newObj;
	}
	
	public void delete(Integer id) {
		try {
			DetalhesDoPedido obj = find(id);
			if(obj != null) {
				repo.deleteById(id);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir DetalhesDoPedido");
		}
	}
	
	public Page<DetalhesDoPedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
		
	public List<DetalhesDoPedido> filtrar(String pesquisa){
		List<DetalhesDoPedido> list = repo.filtrar(pesquisa);
		return list;
	}
}
