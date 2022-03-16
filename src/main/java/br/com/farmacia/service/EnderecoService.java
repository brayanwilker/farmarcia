package br.com.farmacia.service;

import br.com.farmacia.model.EnderecoModel;
import br.com.farmacia.repositories.EnderecoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepositories er;

    // Create
    public EnderecoModel create(EnderecoModel endereco){

        return er.save(endereco);
    }

    //Read (Lista)
    public List<EnderecoModel> buscarTodos(){
        return er.findAll();
    }

    //Read (ID)

    public EnderecoModel buscarId(Long id) throws AccountNotFoundException {
        Optional <EnderecoModel> found = er.findById(id);

        return found.orElseThrow(() -> new AccountNotFoundException((
                "Objeto não encontrado! Id: " + id + ", Tipo: " + EnderecoModel.class.getName())));
    }

    //Update
    public EnderecoModel update(EnderecoModel endereco){

        Optional<EnderecoModel> found = er.findById(endereco.getId());

        if(endereco.getLogradouro() == null){
            endereco.setLogradouro(found.get().getLogradouro());
        }
        if(endereco.getCep() == null){
            endereco.setCep(found.get().getCep());
        }
        if(endereco.getNumero() == null){
            endereco.setNumero(found.get().getNumero());
        }
        return er.save(endereco);


    }
    
    
    // Delete
    public boolean deleteClientForId(Long id){
        Optional<EnderecoModel> found = er.findById(id);
        if(found.isPresent()){
            er.delete(found.get());
            return true;
        }
        return false;
    }
}
