package org.serratec.backend.projetofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;



import io.swagger.annotations.ApiModelProperty;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Long idItemPedido;
	
	@Column(name = "preco_venda")
	@ApiModelProperty(value = "Preço de venda", required = true)
	@DecimalMin(value = "0")
	private Double precoVenda;
	

	// @NotBlank(message = "Campo QUANTIDADE vazio")
	@Column(name = "quantidade")
	@ApiModelProperty(value = "Quantidade", required = true)
	@DecimalMin(value ="1")
	private Integer quantidade; 
	
	
	//Várias pessoas podem pedir o mesmo pedido
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	
	public ItemPedido() {}
	
	public ItemPedido(Long idItemPedido, @DecimalMin("0") Double precoVenda,
			@NotBlank(message = "Campo QUANTIDADE vazio") @DecimalMin("1") Integer quantidade, Produto produto,
			Pedido pedido) {
		super();
		this.idItemPedido = idItemPedido;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}


	/*
	private Long idProduto;
	

	public Long getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
*/

	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Long getIdItemPedido() {
		return idItemPedido;
	}


	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}


	public Double getPrecoVenda() {
		return precoVenda;
	}


	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	
	

}
