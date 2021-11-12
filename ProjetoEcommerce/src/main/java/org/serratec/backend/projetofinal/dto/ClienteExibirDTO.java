package org.serratec.backend.projetofinal.dto;




import java.util.Optional;

import org.serratec.backend.projetofinal.domain.Cliente;
import org.serratec.backend.projetofinal.domain.Endereco;


public class ClienteExibirDTO {

	private Long id;
	private String nome;
	private String email;
	private Endereco endereco;
	//private List<Pedido> pedidos;
	
	public ClienteExibirDTO() {};

	public ClienteExibirDTO(Optional<Cliente> cliente) {

	}
 
	public ClienteExibirDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.endereco = cliente.getEndereco();
		//this.pedidos = cliente.getPedidos();
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
/*
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}*/

}