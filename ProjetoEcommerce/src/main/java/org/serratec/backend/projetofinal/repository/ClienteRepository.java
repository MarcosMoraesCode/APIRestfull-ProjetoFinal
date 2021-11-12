package org.serratec.backend.projetofinal.repository;

import org.serratec.backend.projetofinal.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByEmail(String email);
	Cliente findByCpf(String cpf);

}
