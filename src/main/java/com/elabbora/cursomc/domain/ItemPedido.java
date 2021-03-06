package com.elabbora.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Classe de associação não tem idProprio, vai receber o ID do produto e pedido
@Entity
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore //Como tem uma chave composta, ele deve ser ignorado, não serializado
	@EmbeddedId  //Por ser um tipo embutido em uma classe auxiliar
	private ItemPedidoPK id = new ItemPedidoPK();
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.id = id;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	//O fato de colocar o get no nome, o spring vai serializar e coloca-lo no JSON.
	public double getSubTotal() {
		return (preco - desconto) * quantidade;
	}

	//para acessar os dados do pedido e produto dentro da propria classe
	@JsonIgnore //Se não colocar vai dar erro de referência Ciclica. Tudo que começa com get ele serializa
	public Pedido getPedido() {
		return getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
