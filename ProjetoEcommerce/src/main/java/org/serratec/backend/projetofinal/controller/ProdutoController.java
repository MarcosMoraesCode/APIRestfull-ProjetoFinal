package org.serratec.backend.projetofinal.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;


import org.serratec.backend.projetofinal.dto.ProdutoCadastroDTO;
import org.serratec.backend.projetofinal.dto.ProdutoExibirDTO;
import org.serratec.backend.projetofinal.service.ProdutoService;
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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoExibirDTO>> pesquisarTodosProdutos(){
		List<ProdutoExibirDTO> listaProdutos = produtoService.pesquisarTodosProdutos();
		
		return ResponseEntity.ok(listaProdutos);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoExibirDTO> pesquisarUmProduto(@PathVariable Long id ){ 
		ProdutoExibirDTO produtoDTO = produtoService.pesquisarUmProduto(id);
					
		if(produtoService.existeProduto(id)) {
			return ResponseEntity.ok(produtoDTO);
		} else {
		return ResponseEntity.notFound().build();
		}
		
	} 
	
	@PostMapping
	public ResponseEntity<Object> inserir(@Valid @RequestBody ProdutoCadastroDTO produtoCadastroDTO){
		
			ProdutoExibirDTO produtoDTO = produtoService.inserirProduto(produtoCadastroDTO);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDTO.getId()).toUri();
			
			return ResponseEntity.created(uri).body(produtoDTO);
			
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoExibirDTO> atualizar(@RequestBody ProdutoCadastroDTO produtoCadastro, @PathVariable Long id){
		
		if(!produtoService.existeProduto(id)) {
			
			return ResponseEntity.notFound().build();
		}
		
			
		return ResponseEntity.ok(produtoService.atualizarProduto(produtoCadastro, id));
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		if (!produtoService.existeProduto(id)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(produtoService.removerProduto(id));
	}
	





}
