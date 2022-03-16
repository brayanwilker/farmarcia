package br.com.farmacia.repositories;

import br.com.farmacia.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentosRepositores extends JpaRepository<MedicamentoModel, Long> {


}
