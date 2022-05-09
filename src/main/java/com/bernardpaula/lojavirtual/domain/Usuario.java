package com.bernardpaula.lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String numUsuar;
	private String senha;
	private String estadLog;
	
	@JsonFormat(pattern = "dd/MM/yy")
	private Date dataCadastro;
	
	
	public Usuario() {
		
	}

	public Usuario(Integer id, String numUsuar, String senha, String estadLog, Date dataCadastro) {
		super();
		this.id = id;
		this.numUsuar = numUsuar;
		this.senha = senha;
		this.estadLog = estadLog;
		this.dataCadastro = dataCadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumUsuar() {
		return numUsuar;
	}

	public void setNumUsuar(String numUsuar) {
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
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
