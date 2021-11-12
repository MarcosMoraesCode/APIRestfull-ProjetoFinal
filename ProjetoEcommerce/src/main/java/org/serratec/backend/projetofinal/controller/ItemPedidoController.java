package org.serratec.backend.projetofinal.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetofinal.dto.ItemPedidoCadastroDTO;
import org.serratec.backend.projetofinal.dto.ItemPedidoExibirDTO;
import org.serratec.backend.projetofinal.service.ItemPedidoService;
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
@RequestMapping("/itenspedidos")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@GetMapping
	@ApiOperation(value = "Listar ItensPedidos", notes = "Listar ItensPedidos")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ItensPedidos listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<List<ItemPedidoExibirDTO>> pesquisarTodosItensPedidos(){
		List<ItemPedidoExibirDTO> listaItensPedidos = itemPedidoService.pesquisarTodosItensPedidos();
		
		return ResponseEntity.ok(listaItensPedidos);
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar um ItemPedido", notes = "Buscar um ItemPedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Busca realizada com sucesso"),
			@ApiResponse(code = 201, message = "Cliente localizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<ItemPedidoExibirDTO> pesquisarUmItemPedido(@PathVariable Long id ){ 
		
		ItemPedidoExibirDTO itemPedidoDTO = itemPedidoService.pesquisarUmItemPedido(id);
					
		if(itemPedidoService.existeItemPedido(id)) {
			
			return ResponseEntity.ok(itemPedidoDTO);
			
		} else {
			
		return ResponseEntity.notFound().build();
		
		}
		
	} 
	
	@PostMapping
	@ApiOperation(value = "Inserir determinado ItemPedido", notes = "Inserir ItemPedido")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cliente inserido com sucesso"),
			@ApiResponse(code = 201, message = "Cliente criado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Object> inserir(@Valid @RequestBody ItemPedidoCadastroDTO itemPedidoCadastroDTO){
		
		
			ItemPedidoExibirDTO itemPedidoDTO = itemPedidoService.inserirItemPedido(itemPedidoCadastroDTO);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itemPedidoDTO.getId()).toUri();
			
			
			return ResponseEntity.created(uri).body(itemPedidoDTO);
			
		
		
	}

}
