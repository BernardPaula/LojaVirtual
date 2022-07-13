package com.bernardpaula.lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bernardpaula.lojavirtual.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numUsuar;
	
	@JsonIgnore
	@NotEmpty(message = "Campo Obrigatório!")
	@Column(name="senha")
	private String senha;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max= 80, message="O tamanho deve estar entre 1 e 80 caracteres!")
	@Column(name = "estad_log")
	private String estadLog;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		addPerfil(Perfil.CLIENTE);
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
		addPerfil(Perfil.CLIENTE);
	}

	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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
