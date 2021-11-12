package org.serratec.backend.projetofinal.dto;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import org.serratec.backend.projetofinal.domain.Produto;

public class ProdutoCadastroDTO {
	
	@Size(max = 60, message = "Tamanho máximo de 60 caracteres!")
	private String nome;

	
	@DecimalMin(value = "0.1", message = "Este valor não pode ser menor que 10 centavos!")
	private double precoCompra;
	
	@DecimalMin(value = "0", message = "Este valor não pode ser menor que zero!")
	private Integer quantidade;
	
	@Future(message = "A validade deste produto expirou!")
	private Date validade;
	
	private String nomeCategoria;
	
	
	public ProdutoCadastroDTO () {
		
	}
	
	
	public ProdutoCadastroDTO(Produto produto) {
		super();
		this.nome = produto.getNome();
		this.precoCompra= produto.getPrecoCompra();
		this.quantidade = produto.getQuantidade();
		this.validade = produto.getValidade();
		}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double preco) {
		this.precoCompra = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String categoria) {
		this.nomeCategoria = categoria;
	}

	
	

	
}
