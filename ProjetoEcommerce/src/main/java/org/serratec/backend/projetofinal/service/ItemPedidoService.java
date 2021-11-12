package org.serratec.backend.projetofinal.service;

import java.util.List;

import org.serratec.backend.projetofinal.dto.ItemPedidoCadastroDTO;
import org.serratec.backend.projetofinal.dto.ItemPedidoExibirDTO;

public interface ItemPedidoService {

	List<ItemPedidoExibirDTO> pesquisarTodosItensPedidos();

	ItemPedidoExibirDTO inserirItemPedido(ItemPedidoCadastroDTO itemPedidoCadastroDTO);

	boolean existeItemPedido(Long id);

	ItemPedidoExibirDTO pesquisarUmItemPedido(Long id);

}
