package br.com.farmacia.repositories;

import br.com.farmacia.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositories  extends JpaRepository<ClienteModel, Long> {
}
