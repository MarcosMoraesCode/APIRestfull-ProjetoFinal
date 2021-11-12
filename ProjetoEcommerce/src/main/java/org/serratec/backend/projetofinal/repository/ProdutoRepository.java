package org.serratec.backend.projetofinal.repository;

import org.serratec.backend.projetofinal.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
