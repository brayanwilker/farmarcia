package br.com.farmacia.service;


import br.com.farmacia.model.FuncionarioModel;
import br.com.farmacia.model.MedicamentoModel;
import br.com.farmacia.model.VendaModel;
import br.com.farmacia.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<VendaModel> findAll() {
        return repository.findAll();
    }

    public VendaModel findById(Long id) {
        Optional<VendaModel> optional = repository.findById(id);
        return optional.get();
    }

    // Create/Update
    public void createVenda(MedicamentoModel medicamento, FuncionarioModel funcionario) {
        VendaModel venda = new VendaModel();
        Calendar cal = Calendar.getInstance();
        Date compra = cal.getTime();
        venda.setCompra(compra);
        venda.setValor(medicamento.getValor());
        venda.setNomeProduto(medicamento.getNome());
        venda.setFuncionario(funcionario);
        repository.save(venda);
    }

    // Delete
    public boolean deleteVendaById(Long id){
        Optional<VendaModel> vendaToDelete = repository.findById(id);
        if(vendaToDelete.isPresent()){
            repository.delete(vendaToDelete.get());
            return true;
        }
        return false;
    }
}
