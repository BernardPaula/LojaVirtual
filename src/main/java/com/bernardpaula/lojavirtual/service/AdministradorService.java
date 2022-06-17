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

import com.bernardpaula.lojavirtual.domain.Administrador;
import com.bernardpaula.lojavirtual.repository.AdministradorRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repo;
	
	public Administrador find(Integer id) {
		Optional<Administrador> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + Administrador.class.getName(), null));
	}
	
	public Administrador insert(Administrador obj) {
		obj = repo.save(obj);
		return find(obj.getNumAdm());
	}
	
	public Administrador update(Administrador obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		//repo.deleteById(id);
		try {
			Administrador objCurrent = find(id);
			if(objCurrent != null) {
				repo.deleteById(id);
			}else {
				 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Administrador");
		}
	}
	
	public List<Administrador> findAll() {
		return repo.findAll();
	}
	
	public Page<Administrador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Administrador> filtrar(String pesquisa){
		List<Administrador> list = repo.filtrar(pesquisa);
		return list;
	}
}
