package br.com.fiap.abctechapi.repository;

import br.com.fiap.abctechapi.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
