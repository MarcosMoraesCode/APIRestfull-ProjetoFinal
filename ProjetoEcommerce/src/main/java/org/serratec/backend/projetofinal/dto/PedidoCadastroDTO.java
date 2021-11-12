package org.serratec.backend.projetofinal.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.serratec.backend.projetofinal.domain.Pedido;

public class PedidoCadastroDTO {

		
	private LocalDate dataPedido;
	private Long idCliente;
	//private List<ItemPedido> itens = new ArrayList<>();
	private List<Long> idItemPedido = new ArrayList<>();
	
	public PedidoCadastroDTO(Pedido pedido) {
		super();
		
		this.dataPedido = pedido.getDataPedido();
		this.idCliente = pedido.getCliente().getId();	
		}
	
	public PedidoCadastroDTO() {};
	
	public PedidoCadastroDTO(LocalDate dataPedido, Long idCliente, List<Long> idItemPedido) {
		super();
		this.dataPedido = dataPedido;
		this.idCliente = idCliente;
		this.idItemPedido = idItemPedido;
	}



	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	public List<Long> getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(List<Long> idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
