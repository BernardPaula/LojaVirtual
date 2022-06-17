package com.bernardpaula.lojavirtual.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "informacao_de_envio")
public class InformacaoDeEnvio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numEnvio;
	
	@NotEmpty(message= "Campo Obrigatório")
	@Length(min=1, max = 50, message = "O tamanho deve estar entre 1 e 50 caracteres")
	@Column(name="tipo_envio")
	private String tipoEnvio;
	
	@Column(name= "custo_envio")
	private Integer custoEnvio;
	
	@Column(name="num_regiao_envio")
	private Integer numRegiaoEnvio;
	
	
	
	public InformacaoDeEnvio() {
		
	}


	public InformacaoDeEnvio(Integer numEnvio,
			@NotEmpty(message = "Campo Obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve estar entre 1 e 50 caracteres") String tipoEnvio,
			Integer custoEnvio, Integer numRegiaoEnvio) {
		super();
		this.numEnvio = numEnvio;
		this.tipoEnvio = tipoEnvio;
		this.custoEnvio = custoEnvio;
		this.numRegiaoEnvio = numRegiaoEnvio;
	}


	public Integer getNumEnvio() {
		return numEnvio;
	}


	public void setNumEnvio(Integer numEnvio) {
		this.numEnvio = numEnvio;
	}


	public String getTipoEnvio() {
		return tipoEnvio;
	}


	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}


	public Integer getCustoEnvio() {
		return custoEnvio;
	}


	public void setCustoEnvio(Integer custoEnvio) {
		this.custoEnvio = custoEnvio;
	}


	public Integer getNumRegiaoEnvio() {
		return numRegiaoEnvio;
	}


	public void setNumRegiaoEnvio(Integer numRegiaoEnvio) {
		this.numRegiaoEnvio = numRegiaoEnvio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numEnvio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformacaoDeEnvio other = (InformacaoDeEnvio) obj;
		return Objects.equals(numEnvio, other.numEnvio);
	}
	
	
}
