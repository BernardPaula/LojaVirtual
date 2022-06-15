package com.bernardpaula.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.lojavirtual.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
}
