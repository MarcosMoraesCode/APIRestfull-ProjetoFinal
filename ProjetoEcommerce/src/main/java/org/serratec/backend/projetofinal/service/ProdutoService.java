package org.serratec.backend.projetofinal.service;

import java.util.List;

import org.serratec.backend.projetofinal.dto.ProdutoCadastroDTO;
import org.serratec.backend.projetofinal.dto.ProdutoExibirDTO;


public interface ProdutoService {
	
	public List<ProdutoExibirDTO> pesquisarTodosProdutos();
	public ProdutoExibirDTO pesquisarUmProduto(Long id);
	public ProdutoExibirDTO inserirProduto(ProdutoCadastroDTO produtoCadastro);
	public boolean existeProduto(Long id);
	public String removerProduto(Long id);
	public ProdutoExibirDTO atualizarProduto(ProdutoCadastroDTO produtoCadastro, Long id);
	
	
}
