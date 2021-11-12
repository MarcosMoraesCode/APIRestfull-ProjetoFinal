package org.serratec.backend.projetofinal.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;


import org.serratec.backend.projetofinal.dto.PedidoCadastroDTO;
import org.serratec.backend.projetofinal.dto.PedidoExibirDTO;
import org.serratec.backend.projetofinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@GetMapping
	@ApiOperation(value = "Listar Pedidos", notes = "Listar Pedidos")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pedidos listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<List<PedidoExibirDTO>> listarPedidos(){
		List<PedidoExibirDTO> listaPedidos = pedidoService.listarPedidos();
		
		return ResponseEntity.ok(listaPedidos);
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar um Pedido", notes = "Buscar um Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Busca realizada com sucesso"),
			@ApiResponse(code = 201, message = "Pedido localizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<PedidoExibirDTO> pesquisarUmPedido(@PathVariable Long id ){ 
		
		PedidoExibirDTO pedidoDTO = pedidoService.listarUmPedidoPorId(id);
		
					
		if(pedidoService.existePedido(id)) {
			
			return ResponseEntity.ok(pedidoDTO);
			
		} else {
			
		return ResponseEntity.notFound().build();
		
		}
		
	}
	
	@PostMapping
	@ApiOperation(value = "Inserir determinado Pedido", notes = "Inserir Pedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pedido inserido com sucesso"),
			@ApiResponse(code = 201, message = "Pedido criado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	
	
	public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoCadastroDTO pedidoCadastroDTO){
		
		PedidoExibirDTO pedidoDTO = pedidoService.inserirPedido(pedidoCadastroDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedidoDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pedidoDTO);
		
	}
	
	
}
