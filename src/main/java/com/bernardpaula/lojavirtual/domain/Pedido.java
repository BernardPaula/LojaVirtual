package com.bernardpaula.lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numPedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", unique=true)
	private Date dataCriacao;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max= 80, message="O tamanho deve estar entre 1 e 80 caracteres!")
	@Column(name = "nome_cliente", unique=true)
	private String nomeCliente;
	
	@Column(name = "num_cliente", unique=true)
	private Integer numCliente;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max= 50, message="O tamanho deve estar entre 1 e 80 caracteres!")	
	@Column(name = "estado", unique=true)
	private String estado;
	
	@Column(name = "num_envio", unique=true)
	private Integer numEnvio;
	
	
	
	
	public Pedido() {
		
	}


	public Pedido(Integer numPedido, Date dataCriacao,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres!") String nomeCliente,
			Integer numCliente,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 50, message = "O tamanho deve estar entre 1 e 80 caracteres!") String estado,
			Integer numEnvio) {
		super();
		this.numPedido = numPedido;
		this.dataCriacao = dataCriacao;
		this.nomeCliente = nomeCliente;
		this.numCliente = numCliente;
		this.estado = estado;
		this.numEnvio = numEnvio;
	}


	public Integer getNumPedido() {
		return numPedido;
	}


	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public Integer getNumCliente() {
		return numCliente;
	}


	public void setNumCliente(Integer numCliente) {
		this.numCliente = numCliente;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Integer getNumEnvio() {
		return numEnvio;
	}


	public void setNumEnvio(Integer numEnvio) {
		this.numEnvio = numEnvio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numPedido);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numPedido, other.numPedido);
	}
	
	
	
}
