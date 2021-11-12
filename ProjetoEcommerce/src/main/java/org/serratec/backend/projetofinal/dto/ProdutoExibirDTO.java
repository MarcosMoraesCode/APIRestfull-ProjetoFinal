package org.serratec.backend.projetofinal.dto;

import org.serratec.backend.projetofinal.domain.Categoria;
import org.serratec.backend.projetofinal.domain.Produto;

public class ProdutoExibirDTO {

	private Long id;
	private String nome;
	private Categoria categoria;
	private Integer quantidade;
	private double precoCompra;
	
	public ProdutoExibirDTO() {
		
	}

	public ProdutoExibirDTO(Produto produto) {
		super();
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		this.precoCompra = produto.getPrecoCompra();
		this.categoria = produto.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoVenda) {
		this.precoCompra = precoVenda;
	}
	
	
}


