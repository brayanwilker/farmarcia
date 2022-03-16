package br.com.farmacia.service;

import br.com.farmacia.model.ClienteModel;
import br.com.farmacia.model.EnderecoModel;
import br.com.farmacia.model.FuncionarioModel;
import br.com.farmacia.model.MedicamentoModel;
import br.com.farmacia.repositories.FuncionarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepositories fr;


    // Create
    public FuncionarioModel create(FuncionarioModel funcionario){

        return fr.save(funcionario);
    }

    //Read (Lista)
    public List<FuncionarioModel> buscarTodos(){
        return fr.findAll();
    }

    //Update
    public void update(FuncionarioModel funcionario){

        Optional<FuncionarioModel> found = fr.findById(funcionario.getId());
        if(funcionario.getCpf() == null){
            funcionario.setCpf(found.get().getCpf());
        }
        if(funcionario.getNome() == null){
            funcionario.setNome(found.get().getNome());
        }
        if(funcionario.getTelefone() == null){
            funcionario.setTelefone(found.get().getTelefone());
        }
        if(funcionario.getDtNascimento() == null){
            funcionario.setDtNascimento(found.get().getDtNascimento());
        }
        if(funcionario.getVenda() == null){
            funcionario.setVenda(found.get().getVenda());
        }
        if(funcionario.getComissao() == 0.0){
            funcionario.setComissao(found.get().getComissao());
        }
        if(funcionario.getSalario() == 0.0){
            funcionario.setSalario(found.get().getSalario());
        }
        if(funcionario.getCargo() == null){
            funcionario.setCargo(found.get().getCargo());
        }

        fr.save(funcionario);

    }

    // Delete
    public boolean deleteEmployeeForId(Long id){
        Optional<FuncionarioModel> found = fr.findById(id);
        if(found.isPresent()){
            fr.delete(found.get());
            return true;
        }
        return false;
    }

    //Read (ID)

    public FuncionarioModel buscarId(Long id) throws AccountNotFoundException {
        Optional <FuncionarioModel> found = fr.findById(id);

        return found.orElseThrow(() -> new AccountNotFoundException((
                "Objeto não encontrado! Id: " + id + ", Tipo: " + FuncionarioModel.class.getName())));
    }

    public void comissão(MedicamentoModel medicamento, Long id) throws AccountNotFoundException {
        FuncionarioModel funcionarioModel = buscarId(id);
        double comissão = (medicamento.getValor() * 0.1);

        funcionarioModel.setComissao(funcionarioModel.getComissao() + comissão);
        fr.save(funcionarioModel);
    }
}
