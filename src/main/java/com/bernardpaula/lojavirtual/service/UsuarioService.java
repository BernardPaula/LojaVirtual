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

import com.bernardpaula.lojavirtual.domain.Usuario;
import com.bernardpaula.lojavirtual.repository.UsuarioRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario insert(Usuario obj) {
		try {
		obj.setDataCadastro(new Date());
		obj = repo.save(obj);
		return find(obj.getNumUsuar());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getNumUsuar());
		obj.setDataCadastro(newObj.getDataCadastro());
		newObj = find(obj.getNumUsuar());
		return newObj;
	}
	
	public void delete(Integer id) {
		try {
			Usuario obj = find(id);
			if(obj != null) {
				repo.save(obj);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Usuario");
		}
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	
}
