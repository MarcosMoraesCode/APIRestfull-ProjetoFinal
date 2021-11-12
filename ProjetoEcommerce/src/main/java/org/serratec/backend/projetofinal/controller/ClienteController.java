package org.serratec.backend.projetofinal.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;


import org.serratec.backend.projetofinal.dto.ClienteCadastroDTO;
import org.serratec.backend.projetofinal.dto.ClienteExibirDTO;
import org.serratec.backend.projetofinal.exceptions.CpfException;
import org.serratec.backend.projetofinal.exceptions.EmailException;
import org.serratec.backend.projetofinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//CONFERIR SE POR APIRESPONSES E RESPONSE NA MÃO DA PROBLEMA
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	//AINDA PRECISAMOS FAZER O TRABALHO DE RETORNAR PRO USUÁRIO APENAS OS DADOS TRATADOS EM DTO, AS CLASSES ESTÃO PRONTAS, MAS
	//PRECISAM SER FEITAS ALGUMAS ALTERAÇÕES NO GET, POST, PUT, E DELETE TALVEZ, SEGUNDO SLIDE 20 DA AULA 08
	
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Listar Clientes")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Clientes listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<List<ClienteExibirDTO>> pesquisarTodosClientes(){
		List<ClienteExibirDTO> listaClientes = clienteService.pesquisarTodosClientes();
		
		return ResponseEntity.ok(listaClientes);
		
	}
	
	
	//RETORNANDO ERRO MUITO FEIO QUANDO BUSCO ID NÃO EXISTENTE.
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar um Cliente", notes = "Buscar um Cliente")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Busca realizada com sucesso"),
			@ApiResponse(code = 201, message = "Cliente localizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<ClienteExibirDTO> pesquisarUmCliente(@PathVariable Long id ){ 
		
		ClienteExibirDTO clienteDTO = clienteService.pesquisarUmCliente(id);
					
		if(clienteService.existeCliente(id)) {
			
			return ResponseEntity.ok(clienteDTO);
			
		} else {
			
		return ResponseEntity.notFound().build();
		
		}
		
	} 
	
	@PostMapping
	@ApiOperation(value = "Inserir determinado Cliente", notes = "Inserir Cliente")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cliente inserido com sucesso"),
			@ApiResponse(code = 201, message = "Cliente criado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Object> inserir(@Valid @RequestBody ClienteCadastroDTO clienteCadastroDTO){
		
		try {
			
			ClienteExibirDTO clienteDTO = clienteService.inserirCliente(clienteCadastroDTO);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteDTO.getId()).toUri();
			
			
			return ResponseEntity.created(uri).body(clienteDTO);
			
		}catch (EmailException e){
			
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
			
		}catch(CpfException e) {
			
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar determinado Cliente", notes = "Atualizar Cliente")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cliente atualizado com sucesso"),
			@ApiResponse(code = 201, message = "Cliente atualizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<ClienteExibirDTO> atualizar(@RequestBody ClienteCadastroDTO clienteCadastro, @PathVariable Long id){
		
		if(!clienteService.existeCliente(id)) {
			
			return ResponseEntity.notFound().build();
		}
		
			
		return ResponseEntity.ok(clienteService.atualizarCliente(clienteCadastro, id));
		
		
	}
	
	//Não preciso setar o id?
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remover determinado Cliente", notes = "Remover Cliente")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cliente atualizado com sucesso"),
			@ApiResponse(code = 201, message = "Cliente atualizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 422, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<String> remover(@PathVariable Long id) {
		if (!clienteService.existeCliente(id)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(clienteService.removerCliente(id));
	}
	
	
	

}
