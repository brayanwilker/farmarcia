package br.com.farmacia.service;


import br.com.farmacia.model.ClienteModel;
import br.com.farmacia.model.MedicamentoModel;
import br.com.farmacia.repositories.MedicamentosRepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    MedicamentosRepositores mr;

    // Create
    public MedicamentoModel create(MedicamentoModel medicamento){

        return mr.save(medicamento);
    }

    //Read (Lista)
    public List<MedicamentoModel> buscarTodos(){
        return mr.findAll();
    }

    //Update
    public void update(MedicamentoModel medicamento){

        Optional<MedicamentoModel> found = mr.findById(medicamento.getId());
        if(medicamento.getValor() == 0.00){
            medicamento.setValor(found.get().getValor());
        }
        if(medicamento.getNome() == null){
            medicamento.setNome(found.get().getNome());
        }
        if(medicamento.getDescrição() == null){
            medicamento.setDescrição(found.get().getDescrição());
        }
        if(medicamento.getValidade() == null){
            medicamento.setValidade(found.get().getValidade());
        }
        if(medicamento.getTarja() == null){
            medicamento.setTarja(found.get().getTarja());
        }

        mr.save(medicamento);

    }

    public boolean deleteMedicineForId(Long id){
        Optional<MedicamentoModel> found = mr.findById(id);
        if(found.isPresent()){
            mr.delete(found.get());
            return true;
        }
        return false;
    }

    //Read (ID)

    public MedicamentoModel buscarId(Long id) throws AccountNotFoundException {
        Optional <MedicamentoModel> found = mr.findById(id);

        return found.orElseThrow(() -> new AccountNotFoundException((
                "Objeto não encontrado! Id: " + id + ", Tipo: " + MedicamentoModel.class.getName())));
    }
    }
