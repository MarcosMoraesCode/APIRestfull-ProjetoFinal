package org.serratec.backend.projetofinal.dto;

import javax.validation.constraints.Size;

import org.serratec.backend.projetofinal.domain.Categoria;

public class CategoriaCadastroDTO {
	
	@Size(max = 40, message = "O nome da categoria não deve ultrapassar 40 caracteres.")
	private String nome;
	
	@Size(max = 200, message = "A descrição não deve ultrapassar 200 caracteres.")
	private String descricao;
	
	public CategoriaCadastroDTO() {
		
	}

	public CategoriaCadastroDTO(Categoria categoria) {
		super();
			this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}