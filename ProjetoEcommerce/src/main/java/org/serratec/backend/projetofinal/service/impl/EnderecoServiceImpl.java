package org.serratec.backend.projetofinal.service.impl;


import org.serratec.backend.projetofinal.domain.Endereco;

import org.serratec.backend.projetofinal.repository.EnderecoRepository;
import org.serratec.backend.projetofinal.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco buscarCep(String cep) throws HttpClientErrorException {
		
						
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Endereco enderecoViaCep = restTemplate.getForObject(uri, Endereco.class);
			
			String cepSemTraco = enderecoViaCep.getCep().replaceAll("-", "");
			enderecoViaCep.setCep(cepSemTraco);
			return enderecoViaCep;
				
	}	
			
			
		
	
	




	
	

}