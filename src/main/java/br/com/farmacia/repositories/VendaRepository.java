package br.com.farmacia.repositories;

import br.com.farmacia.model.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaModel, Long> {
}
