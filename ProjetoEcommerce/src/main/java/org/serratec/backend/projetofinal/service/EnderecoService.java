package org.serratec.backend.projetofinal.service;



import org.serratec.backend.projetofinal.domain.Endereco;
import org.serratec.backend.projetofinal.dto.EnderecoDTO;

public interface EnderecoService {
	
	public Endereco buscarCep(String cep);
	

}
 