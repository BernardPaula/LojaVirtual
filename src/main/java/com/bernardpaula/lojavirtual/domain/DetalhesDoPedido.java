package com.bernardpaula.lojavirtual.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="detatlhes_do_pedido")
public class DetalhesDoPedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numPedido;
	
	
	@Column(name="num_produto", unique=true)
	private Integer numProduto;
	
	@NotEmpty(message = "Campo Obrigatório")
	@Length(min=1, max = 100, message= "O tamanho deve estar entre 1 e 80 caracteres!")
	@Column(name="nome_produto", unique=true)
	private String nomeProduto;
	
	@Column(name="quantidade", unique=true)
	private Integer quantidade;
	
	@Column(name="custo_unidade", unique=true)
	private float custoUnidade;
	
	@Column(name="subtotal", unique=true)
	private float subtotal;
	
	
	
	public DetalhesDoPedido() {
		
	}


	public DetalhesDoPedido(Integer numPedido, Integer numProduto,
			@NotEmpty(message = "Campo Obrigatório") @Length(min = 1, max = 100, message = "O tamanho deve estar entre 1 e 80 caracteres!") String nomeProduto,
			Integer quantidade, float custoUnidade, float subtotal) {
		super();
		this.numPedido = numPedido;
		this.numProduto = numProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.custoUnidade = custoUnidade;
		this.subtotal = subtotal;
	}


	public Integer getNumPedido() {
		return numPedido;
	}


	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}


	public Integer getNumProduto() {
		return numProduto;
	}


	public void setNumProduto(Integer numProduto) {
		this.numProduto = numProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public float getCustoUnidade() {
		return custoUnidade;
	}


	public void setCustoUnidade(float custoUnidade) {
		this.custoUnidade = custoUnidade;
	}


	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
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
		DetalhesDoPedido other = (DetalhesDoPedido) obj;
		return Objects.equals(numPedido, other.numPedido);
	}
	
	
}
