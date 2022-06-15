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
@Table(name = "admnistrador")
public class Administrador implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numAdm;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max= 80, message="O tamanho deve estar entre 1 e 80 caracteres!")
	@Column(name= "administrador", unique = true)
	private String nomeAdm;
	
	@Email
	private String email;
	
	
	public Administrador() {
		
	}


	public Administrador(Integer numAdm,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres!") String nomeAdm,
			@Email String email) {
		super();
		this.numAdm = numAdm;
		this.nomeAdm = nomeAdm;
		this.email = email;
	}


	public Integer getNumAdm() {
		return numAdm;
	}


	public void setNumAdm(Integer numAdm) {
		this.numAdm = numAdm;
	}


	public String getNomeAdm() {
		return nomeAdm;
	}


	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numAdm);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(numAdm, other.numAdm);
	}
	
	
	
}
