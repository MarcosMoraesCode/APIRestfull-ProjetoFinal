package org.serratec.backend.projetofinal.service;

import java.util.List;

import org.serratec.backend.projetofinal.domain.Categoria;
import org.serratec.backend.projetofinal.dto.CategoriaCadastroDTO;
import org.serratec.backend.projetofinal.dto.CategoriaExibirDTO;



public interface CategoriaService {
	public List<CategoriaExibirDTO> pesquisarTodasCategorias();
	public CategoriaExibirDTO inserirCategoria(CategoriaCadastroDTO categoriaCadastro);
	public CategoriaExibirDTO pesquisarUmaCategoria(Long id);
	public CategoriaExibirDTO atualizarCategoria(CategoriaCadastroDTO categoriaCadastro, Long id);
	public boolean existeCategoria(Long id);
	public String removerCategoria(Long id);
	public Categoria confereCategoriaPorNome(String nomeCategoria);
	

}
