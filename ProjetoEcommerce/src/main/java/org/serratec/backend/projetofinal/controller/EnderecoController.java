package org.serratec.backend.projetofinal.controller;


import org.serratec.backend.projetofinal.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	/*
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep){
		
		EnderecoDTO enderecoDTO = enderecoService.buscarCep(cep);
		
		if(enderecoDTO == null) {
			
			return ResponseEntity.notFound().build();
			
		} else {
			
			return ResponseEntity.ok(enderecoDTO);
			
		}
	}
	*/

	
	
}
