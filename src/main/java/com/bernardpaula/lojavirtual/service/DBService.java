package com.bernardpaula.lojavirtual.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.lojavirtual.domain.Administrador;
import com.bernardpaula.lojavirtual.domain.CarrinhoDeCompras;
import com.bernardpaula.lojavirtual.domain.Cliente;
import com.bernardpaula.lojavirtual.domain.DetalhesDoPedido;
import com.bernardpaula.lojavirtual.domain.InformacaoDeEnvio;
import com.bernardpaula.lojavirtual.domain.Pedido;
import com.bernardpaula.lojavirtual.domain.Usuario;
import com.bernardpaula.lojavirtual.repository.AdministradorRepository;
import com.bernardpaula.lojavirtual.repository.CarrinhoDeComprasRepository;
import com.bernardpaula.lojavirtual.repository.ClienteRepository;
import com.bernardpaula.lojavirtual.repository.DetalhesDoPedidoRepository;
import com.bernardpaula.lojavirtual.repository.InformacaoDeEnvioRepository;
import com.bernardpaula.lojavirtual.repository.PedidoRepository;
import com.bernardpaula.lojavirtual.repository.UsuarioRepository;

@Service
public class DBService {

	
	@Autowired
	private AdministradorRepository admRepo;
	
	@Autowired
	private CarrinhoDeComprasRepository cdcRepo;
	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private DetalhesDoPedidoRepository dpRepo;

	@Autowired
	private InformacaoDeEnvioRepository ideRepo;
	
	@Autowired
	private PedidoRepository pedRepo;
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	
	public void instantiageDatabase() {
		Administrador adm1 = new Administrador(null, "João", "joao@gmail.com");
		Administrador adm2 = new Administrador(null, "Maria", "maria@gmail.com");
		Administrador adm3 = new Administrador(null, "Leticia", "leticia@gmail.com");
		Administrador adm4 = new Administrador(null, "Pedro", "pedro@gmail.com");
		Administrador adm5 = new Administrador(null, "Laura", "laura@gmail.com");
		
		admRepo.saveAll(Arrays.asList(adm1, adm2, adm3, adm4, adm5));
		
				
		CarrinhoDeCompras cdc1 = new CarrinhoDeCompras(null, 1, 3, null);
		CarrinhoDeCompras cdc2 = new CarrinhoDeCompras(null, 2, 2, null);
		CarrinhoDeCompras cdc3 = new CarrinhoDeCompras(null, 3, 5, null);
		CarrinhoDeCompras cdc4 = new CarrinhoDeCompras(null, 4, 6, null);
		
		cdcRepo.saveAll(Arrays.asList(cdc1, cdc2, cdc3, cdc4));		
		
		
		Cliente cli1 = new Cliente(null, "João", "Rua Amarela", "joao@gmail.com", "aaa", "bbb", 2f);
		Cliente cli2 = new Cliente(null, "Felipe", "Rua Vermelha", "felipe@gmail.com", "ddd", "ccc", 3f);
		Cliente cli3 = new Cliente(null, "Maria", "Rua Roxa", "maria@gmail.com", "aba", "eee", 20f);
		Cliente cli4 = new Cliente(null, "Fernanda", "Rua Das Flores", "fernanda@gmail.com", "ddd", "ddd", 2.6f);
		
		cliRepo.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
			
				
		
		InformacaoDeEnvio ide1 = new InformacaoDeEnvio(null, "Longo", 32, 2);
		InformacaoDeEnvio ide2 = new InformacaoDeEnvio(null, "Curto", 25, 2);
		InformacaoDeEnvio ide3 = new InformacaoDeEnvio(null, "Curto", 40, 5);
		InformacaoDeEnvio ide4 = new InformacaoDeEnvio(null, "Longo", 32, 3);
		InformacaoDeEnvio ide5 = new InformacaoDeEnvio(null, "Especial", 300, 3);
		
		ideRepo.saveAll(Arrays.asList(ide1, ide2, ide3, ide4, ide5));
		
		
		
		DetalhesDoPedido ddp1 = new DetalhesDoPedido(null, 2, "bala", 20, 3f, 4f);
		DetalhesDoPedido ddp2 = new DetalhesDoPedido(null, 3, "sapato", 13, 3f, 7f);
		DetalhesDoPedido ddp3 = new DetalhesDoPedido(null, 8, "caneta", 84, 4f, 8f);
		DetalhesDoPedido ddp4 = new DetalhesDoPedido(null, 4, "planta", 14, 5f, 4f);
		DetalhesDoPedido ddp5 = new DetalhesDoPedido(null, 1, "mochila", 30, 8f, 6f);			
		
		Pedido ped1 = new Pedido(null, null, "Chico", 4, "Minas Gerais", 1245, ddp1);
		Pedido ped2 = new Pedido(null, null, "Marcio", 5, "Minas Gerais", 13432, ddp2);
		Pedido ped3 = new Pedido(null, null, "Juvelina", 3, "Paraná", 1234123, ddp3);
		Pedido ped4 = new Pedido(null, null, "Ana Paula", 1, "Bahia", 145345245, ddp4);
		Pedido ped5 = new Pedido(null, null, "Francisco", 2, "São Paulo", 134245, ddp5);
			
		
		dpRepo.saveAll(Arrays.asList(ddp1, ddp2, ddp3, ddp4, ddp5));
		pedRepo.saveAll(Arrays.asList(ped1, ped2, ped3, ped4, ped5));
		
		
		
		Usuario usu1 = new Usuario(null, "12456", "aaa", null);
		Usuario usu2 = new Usuario(null, "546666", "bbb", null);
		Usuario usu3 = new Usuario(null, "aas6f6", "ccc", null);
		Usuario usu4 = new Usuario(null, "16sda45", "ddd", null);
		Usuario usu5 = new Usuario(null, "ad65hj5", "eee", null);
		
		usuRepo.saveAll(Arrays.asList(usu1, usu2, usu3, usu4, usu5));
		
	}
}
