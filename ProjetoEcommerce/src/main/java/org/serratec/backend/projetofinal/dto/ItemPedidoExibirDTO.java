package org.serratec.backend.projetofinal.dto;

import org.serratec.backend.projetofinal.domain.ItemPedido;

public class ItemPedidoExibirDTO {
	
	private Long id;
	private Integer quantidade;
	private double precoVenda;
	private String nomeProduto;
	//private String nomeCategoria e descrição se quiser
	
	
	
	public ItemPedidoExibirDTO() {};
	
	public ItemPedidoExibirDTO(ItemPedido itemPedido) {
		super();
		this.nomeProduto = itemPedido.getProduto().getNome();
		this.id = itemPedido.getIdItemPedido();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();		
	}
	
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	

}
