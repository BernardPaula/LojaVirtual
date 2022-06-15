package com.bernardpaula.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.lojavirtual.repository.DetalhesDoPedidoRepository;

@Service
public class DetalhesDoPedidoService {

	@Autowired
	private DetalhesDoPedidoRepository repo;
}
