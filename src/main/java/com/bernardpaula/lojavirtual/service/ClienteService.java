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

import com.bernardpaula.lojavirtual.domain.Cliente;
import com.bernardpaula.lojavirtual.repository.ClienteRepository;
import com.bernardpaula.lojavirtual.service.exceptions.DataIntegrityException;
import com.bernardpaula.lojavirtual.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName(), null));
	}
	
	public Cliente insert(Cliente obj) {
		obj = repo.save(obj);
		return find(obj.getNumCliente());
	}
	
	public Cliente update(Cliente obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		//repo.deleteById(id);
		try {
			Cliente objCurrent = find(id);
			if(objCurrent != null) {
				repo.deleteById(id);
			}else {
				 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada!");
			}
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Cliente");
		}
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Cliente> filtrar(String pesquisa){
		List<Cliente> list = repo.filtrar(pesquisa);
		return list;
	}
}
