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

import com.bernardpaula.lojavirtual.domain.InformacaoDeEnvio;
import com.bernardpaula.lojavirtual.repository.InformacaoDeEnvioRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class InformacaoDeEnvioService {

	@Autowired
	private InformacaoDeEnvioRepository repo;
	
	
	public InformacaoDeEnvio find(Integer id) {
		Optional<InformacaoDeEnvio> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + InformacaoDeEnvio.class.getName()));
	}
	
	public List<InformacaoDeEnvio> findAll() {
		return repo.findAll();
	}
	
	public InformacaoDeEnvio insert(InformacaoDeEnvio obj) {
		try {
		obj = repo.save(obj);
		return find(obj.getNumEnvio());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public InformacaoDeEnvio update(InformacaoDeEnvio obj) {
		InformacaoDeEnvio newObj = find(obj.getNumEnvio());
		newObj = repo.save(obj);
		return newObj;
	}
	
	public void delete(Integer id) {
		try {
			InformacaoDeEnvio obj = find(id);
			if(obj != null) {
				repo.deleteById(id);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir InformacaoDeEnvio");
		}
	}
	

	public Page<InformacaoDeEnvio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
		
	public List<InformacaoDeEnvio> filtrar(String pesquisa){
		List<InformacaoDeEnvio> list = repo.filtrar(pesquisa);
		return list;
	}
	
}
