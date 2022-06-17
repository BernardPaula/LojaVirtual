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

import com.bernardpaula.lojavirtual.domain.CarrinhoDeCompras;
import com.bernardpaula.lojavirtual.repository.CarrinhoDeComprasRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class CarrinhoDeComprasService {

	@Autowired
	private CarrinhoDeComprasRepository repo;
	
	public CarrinhoDeCompras find(Integer id) {
		Optional<CarrinhoDeCompras> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + CarrinhoDeCompras.class.getName(), null));
	}
	
	public CarrinhoDeCompras insert(CarrinhoDeCompras obj) {
		obj.setDataAdd(new Date());
		obj = repo.save(obj);
		return find(obj.getNumCarrinho());
	}
	
	public CarrinhoDeCompras update(CarrinhoDeCompras obj) {
		CarrinhoDeCompras objCurrent = find(obj.getNumCarrinho());
		obj.setDataAdd(objCurrent.getDataAdd());
		repo.save(obj);
		return find(obj.getNumCarrinho());
		
		//return repo.save(obj);
	}
	
	public void delete(Integer id) {
		//repo.deleteById(id);
		try {
			CarrinhoDeCompras objCurrent = find(id);
			if(objCurrent != null) {
				repo.deleteById(id);
			}else {
				 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir CarrinhoDeCompras");
		}
	}
	
	public List<CarrinhoDeCompras> findAll() {
		return repo.findAll();
	}
	
	public Page<CarrinhoDeCompras> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
}
