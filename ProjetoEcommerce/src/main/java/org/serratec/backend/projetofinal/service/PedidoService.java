package org.serratec.backend.projetofinal.service;

import java.util.List;

import org.serratec.backend.projetofinal.dto.PedidoCadastroDTO;
import org.serratec.backend.projetofinal.dto.PedidoExibirDTO;

public interface PedidoService {

	List<PedidoExibirDTO> listarPedidos();

	PedidoExibirDTO listarUmPedidoPorId(Long id);

	String removerProduto(Long id);

	boolean existePedido(Long id);

	PedidoExibirDTO inserirPedido(PedidoCadastroDTO pedidoCadastroDTO);
	

}
