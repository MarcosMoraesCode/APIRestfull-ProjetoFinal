package org.serratec.backend.projetofinal.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.serratec.backend.projetofinal.domain.ItemPedido;
import org.serratec.backend.projetofinal.domain.Pedido;

public class PedidoExibirDTO {
	
		private LocalDate dataPedido;
		private String nomeCliente;
		private String email;
		private String cep;
		private String bairro;
		private Long id; 
		//TALVEZ NAO PRECISE DO CLIENTE AQUI
		//private Cliente cliente;
		
		//CONVERTER ITENS PEDIDOS PARA ITENS PEDIDOS DTO NA LINHA 28
		private List<ItemPedido> itensPedidos = new ArrayList<>();
		
		public PedidoExibirDTO(Pedido pedido) {
			super();
			this.dataPedido = pedido.getDataPedido();
			this.id = pedido.getId();
			this.nomeCliente = pedido.getCliente().getNome();
			this.email = pedido.getCliente().getEmail();
			this.cep = pedido.getCliente().getEndereco().getCep();
			this.bairro = pedido.getCliente().getEndereco().getBairro();
			this.itensPedidos = pedido.getItens();
		}
		
		
		
		public PedidoExibirDTO() {
			// TODO Auto-generated constructor stub
		}
		public LocalDate getDataPedido() {
			return dataPedido;
		}
		public void setDataPedido(LocalDate dataPedido) {
			this.dataPedido = dataPedido;
		}
		public String getNomeCliente() {
			return nomeCliente;
		}
		public void setNomeCliente(String nome) {
			this.nomeCliente = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public List<ItemPedido> getItensPedidos() {
			return itensPedidos;
		}
		public void setItensPedidos(List<ItemPedido> itensPedidos) {
			this.itensPedidos = itensPedidos;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
/*
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
	*/	
	}


