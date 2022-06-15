package com.bernardpaula.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.lojavirtual.repository.InformacaoDeEnvioRepository;

@Service
public class InformacaoDeEnvioService {

	@Autowired
	private InformacaoDeEnvioRepository repo;
}
