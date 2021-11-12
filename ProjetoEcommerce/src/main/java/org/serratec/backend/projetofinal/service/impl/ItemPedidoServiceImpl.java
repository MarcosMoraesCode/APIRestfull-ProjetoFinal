package org.serratec.backend.projetofinal.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.serratec.backend.projetofinal.domain.ItemPedido;
import org.serratec.backend.projetofinal.dto.ItemPedidoCadastroDTO;
import org.serratec.backend.projetofinal.dto.ItemPedidoExibirDTO;
import org.serratec.backend.projetofinal.repository.ItemPedidoRepository;
import org.serratec.backend.projetofinal.repository.ProdutoRepository;
import org.serratec.backend.projetofinal.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService{
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	@Override
	public List<ItemPedidoExibirDTO> pesquisarTodosItensPedidos() {
		
		List<ItemPedido> itensPedidos = itemPedidoRepository.findAll();
		List<ItemPedidoExibirDTO> itensPedidosDTO = new ArrayList<ItemPedidoExibirDTO>();
		
		for (ItemPedido itemPedido : itensPedidos) {
			
			ItemPedidoExibirDTO itemPedidoDTO = new ItemPedidoExibirDTO(itemPedido);
			itensPedidosDTO.add(itemPedidoDTO);
			
			}
		
		return itensPedidosDTO;
	}
	
	@Override
	public ItemPedidoExibirDTO inserirItemPedido(ItemPedidoCadastroDTO itemPedidoCadastroDTO) {
		
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPrecoVenda(itemPedidoCadastroDTO.getPrecoVenda());
		itemPedido.setQuantidade(itemPedidoCadastroDTO.getQuantidade());
		
		itemPedido.setProduto(produtoRepository.findById(itemPedidoCadastroDTO.getIdProduto()).get());
	
		itemPedido = itemPedidoRepository.save(itemPedido);
		 
		
			
		return new ItemPedidoExibirDTO(itemPedido);
		
		//novoCliente.setSenha(passwordEncoder.encode(novoCliente.getSenha()));
		
	} 
	
	@Override
	public boolean existeItemPedido(Long id) {
		// TODO Auto-generated method stub
		
		return itemPedidoRepository.existsById(id);
	}

	
	//FAZER O RETORNO CERTINHO
	@Override
	public ItemPedidoExibirDTO pesquisarUmItemPedido(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
