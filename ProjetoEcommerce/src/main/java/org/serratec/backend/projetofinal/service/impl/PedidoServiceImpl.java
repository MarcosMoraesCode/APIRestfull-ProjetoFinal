package org.serratec.backend.projetofinal.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projetofinal.domain.ItemPedido;
import org.serratec.backend.projetofinal.domain.Pedido;
import org.serratec.backend.projetofinal.dto.PedidoCadastroDTO;
import org.serratec.backend.projetofinal.dto.PedidoExibirDTO;
import org.serratec.backend.projetofinal.repository.ClienteRepository;
import org.serratec.backend.projetofinal.repository.ItemPedidoRepository;
import org.serratec.backend.projetofinal.repository.PedidoRepository;
import org.serratec.backend.projetofinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository; 
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<PedidoExibirDTO> listarPedidos() {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoExibirDTO> pedidosDTO = new ArrayList<>();
		
		for (Pedido pedido : pedidos) {
			
			PedidoExibirDTO pedidoDTO = new PedidoExibirDTO(pedido);
			pedidosDTO.add(pedidoDTO);
		}
		
		return pedidosDTO;
	}
	
	@Override
	public PedidoExibirDTO listarUmPedidoPorId(Long id) {
		
					
		PedidoExibirDTO pedidoDTO = new PedidoExibirDTO();
		pedidoDTO.setDataPedido(pedidoRepository.findById(id).get().getDataPedido());
	//	pedidoDTO.setCliente(pedidoRepository.findById(id).get().getCliente());
		pedidoDTO.setId(pedidoRepository.findById(id).get().getId());
		pedidoDTO.setCep(pedidoRepository.findById(id).get().getCliente().getEndereco().getCep());
		pedidoDTO.setBairro(pedidoRepository.findById(id).get().getCliente().getEndereco().getBairro());
		pedidoDTO.setEmail(pedidoRepository.findById(id).get().getCliente().getEmail());
		pedidoDTO.setNomeCliente(pedidoRepository.findById(id).get().getCliente().getNome());
					
		return pedidoDTO;
		
	}
	
	@Override
	public String removerProduto(Long id) {
		// TODO Auto-generated method stub
		
		pedidoRepository.deleteById(id);
		
		return "Pedido Deletado!";
		
	}
	
	@Override
	public boolean existePedido(Long id) {
		// TODO Auto-generated method stub
		
		return pedidoRepository.existsById(id);
	}
	
	@Override
	public PedidoExibirDTO inserirPedido(PedidoCadastroDTO pedidoCadastroDTO) {
		
		Pedido pedido = new Pedido();
	
		pedido.setDataPedido(pedidoCadastroDTO.getDataPedido());
		pedido.setCliente(clienteRepository.findById(pedidoCadastroDTO.getIdCliente()).get());
		//set itens pede uma lista de itempedido 
		pedido.setItens(insereListaItemPedido(pedidoCadastroDTO.getIdItemPedido()));
		
		pedido = pedidoRepository.save(pedido);
	
		
		
	return new PedidoExibirDTO(pedido);
	}
	
	public List<ItemPedido> insereListaItemPedido(List<Long> idItensPedidos) { 
		
		List<ItemPedido> itensPedidos = new ArrayList<>();
		
		
		for (Long idItemPedido : idItensPedidos) {
			
			itensPedidos.add(itemPedidoRepository.findById(idItemPedido).get());
					    
		}
		
		return itensPedidos;
		
	}
	
}
