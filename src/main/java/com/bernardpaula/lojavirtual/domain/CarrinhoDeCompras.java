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

@Entity
@Table(name= "carrinho_de_compras")
public class CarrinhoDeCompras implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numCarrinho;
	
	@Column(name = "num_produto", unique=true)
	private Integer numProduto;
	
	@Column(name="quandidade", unique=true)
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdd;
	
	
	public CarrinhoDeCompras() {
		
	}


	public CarrinhoDeCompras(Integer numCarrinho, Integer numProduto, Integer quantidade, Date dataAdd) {
		super();
		this.numCarrinho = numCarrinho;
		this.numProduto = numProduto;
		this.quantidade = quantidade;
		this.dataAdd = dataAdd;
	}


	public Integer getNumCarrinho() {
		return numCarrinho;
	}


	public void setNumCarrinho(Integer numCarrinho) {
		this.numCarrinho = numCarrinho;
	}


	public Integer getNumProduto() {
		return numProduto;
	}


	public void setNumProduto(Integer numProduto) {
		this.numProduto = numProduto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Date getDataAdd() {
		return dataAdd;
	}


	public void setDataAdd(Date dataAdd) {
		this.dataAdd = dataAdd;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numCarrinho);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarrinhoDeCompras other = (CarrinhoDeCompras) obj;
		return Objects.equals(numCarrinho, other.numCarrinho);
	}
	
	
}
