package com.bernardpaula.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.lojavirtual.repository.CarrinhoDeComprasRepository;

@Service
public class CarrinhoDeComprasService {

	@Autowired
	private CarrinhoDeComprasRepository repo;
}
