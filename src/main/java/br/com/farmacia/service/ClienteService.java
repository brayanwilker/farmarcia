package br.com.farmacia.service;

import br.com.farmacia.model.ClienteModel;
import br.com.farmacia.model.EnderecoModel;
import br.com.farmacia.repositories.ClienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepositories cr;

    // Create
    public ClienteModel create(ClienteModel cliente){

        return cr.save(cliente);
    }

    //Read (Lista)
    public List<ClienteModel> buscarTodos(){
        return cr.findAll();
    }

    //Update
    public void update(ClienteModel cliente){

        Optional<ClienteModel> found = cr.findById(cliente.getId());
        if(cliente.getCpf() == null){
            cliente.setCpf(found.get().getCpf());
        }
        if(cliente.getNome() == null){
            cliente.setNome(found.get().getNome());
        }
        if(cliente.getTelefone() == null){
            cliente.setTelefone(found.get().getTelefone());
        }
        if(cliente.getDtNascimento() == null){
            cliente.setDtNascimento(found.get().getDtNascimento());
        }

        cr.save(cliente);

    }

    //Delete

    // Delete
    public boolean deleteClientForId(Long id){
        Optional<ClienteModel> found = cr.findById(id);
        if(found.isPresent()){
            cr.delete(found.get());
            return true;
        }
        return false;
    }

    //Read (ID)

    public ClienteModel buscarId(Long id) throws AccountNotFoundException {
        Optional <ClienteModel> found = cr.findById(id);

        return found.orElseThrow(() -> new AccountNotFoundException((
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteModel.class.getName())));
    }

}
