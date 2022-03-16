package br.com.farmacia.repositories;

import br.com.farmacia.model.ClienteModel;
import br.com.farmacia.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositories extends JpaRepository<EnderecoModel, Long> {
}
