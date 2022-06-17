package com.bernardpaula.lojavirtual.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numCliente;
	
	@NotEmpty(message="Campo Obrigatório!")
	@Length(min=1, max=80, message= "O tamanho deve estar entre 1 e 80 caracteres!")
	@Column(name="nome_cliente", unique=true)
	private String nomeCliente;
	
	@NotEmpty(message="Campo Obrigatório!")
	@Length(min=1, max=130, message= "O tamanho deve estar entre 1 e 130 caracteres!")
	@Column(name="endereco", unique=true)
	private String endereco;
	
	@Email
	private String email;
	
	@Column(name="info_cartao_cred" )
	private String infoCartaoCred;
	
	@Column(name="info_envio")
	private String infoEnvio;
	
	@Column(name="saldo_conta")
	private float saldoConta;
	
	
	
	public Cliente() {
		
	}

	

	public Cliente(Integer numCliente,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres!") String nomeCliente,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 130, message = "O tamanho deve estar entre 1 e 130 caracteres!") String endereco,
			@Email String email, String infoCartaoCred, String infoEnvio, float saldoConta) {
		super();
		this.numCliente = numCliente;
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
		this.email = email;
		this.infoCartaoCred = infoCartaoCred;
		this.infoEnvio = infoEnvio;
		this.saldoConta = saldoConta;
	}



	public Integer getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(Integer numCliente) {
		this.numCliente = numCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfoCartaoCred() {
		return infoCartaoCred;
	}

	public void setInfoCartaoCred(String infoCartaoCred) {
		this.infoCartaoCred = infoCartaoCred;
	}

	public String getInfoEnvio() {
		return infoEnvio;
	}

	public void setInfoEnvio(String infoEnvio) {
		this.infoEnvio = infoEnvio;
	}

	public float getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(float saldoConta) {
		this.saldoConta = saldoConta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(numCliente, other.numCliente);
	}
	
	
}
