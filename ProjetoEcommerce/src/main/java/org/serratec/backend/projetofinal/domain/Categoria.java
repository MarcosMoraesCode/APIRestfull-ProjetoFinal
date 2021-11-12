package org.serratec.backend.projetofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	@ApiModelProperty(value = "Identificado único de Categoria")
	private Long id;
	
	
	@NotBlank(message = "O nome da categoria não pode estar vazio.")
	@Size(max = 40, message = "O nome da categoria não deve ultrapassar 40 caracteres.")
	@Column
	@ApiModelProperty(value = "Nome", required = true)
	private String nome;

	@Size(max = 200, message = "A descrição não deve ultrapassar 200 caracteres.")
	@Column
	@ApiModelProperty(value = "Descrição", required = true)
	private String descricao;
	

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
