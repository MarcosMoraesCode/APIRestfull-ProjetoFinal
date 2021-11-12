package org.serratec.backend.projetofinal.service;

import java.util.List;

import org.serratec.backend.projetofinal.dto.ClienteCadastroDTO;
import org.serratec.backend.projetofinal.dto.ClienteExibirDTO;

public interface ClienteService {
	
	public List<ClienteExibirDTO> pesquisarTodosClientes();
	public ClienteExibirDTO pesquisarUmCliente(Long id);
	public ClienteExibirDTO inserirCliente(ClienteCadastroDTO cliente);
	public boolean existeCliente(Long id);
	public String removerCliente(Long id);
	public ClienteExibirDTO atualizarCliente(ClienteCadastroDTO clienteCadastro, Long id);
		
}
