package br.com.farmacia.repositories;

import br.com.farmacia.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositories  extends JpaRepository<FuncionarioModel, Long> {

}
