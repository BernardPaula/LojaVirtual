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
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numUsuar;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max= 15, message="O tamanho deve estar entre 1 e 15 caracteres!")
	@Column(name="senha", unique=true)
	private String senha;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max= 80, message="O tamanho deve estar entre 1 e 80 caracteres!")
	@Column(name = "estad_log")
	private String estadLog;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	
	public Usuario() {
		
	}


	public Usuario(Integer numUsuar,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 15, message = "O tamanho deve estar entre 1 e 15 caracteres!") String senha,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres!") String estadLog,
			Date dataCadastro) {
		super();
		this.numUsuar = numUsuar;
		this.senha = senha;
		this.estadLog = estadLog;
		this.dataCadastro = dataCadastro;
	}


	public Integer getNumUsuar() {
		return numUsuar;
	}


	public void setNumUsuar(Integer numUsuar) {
		this.numUsuar = numUsuar;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEstadLog() {
		return estadLog;
	}


	public void setEstadLog(String estadLog) {
		this.estadLog = estadLog;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numUsuar);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(numUsuar, other.numUsuar);
	}

	
}
