package br.com.farmacia.API;

import br.com.farmacia.model.ClienteModel;
import br.com.farmacia.model.EnderecoModel;
import br.com.farmacia.service.ClienteService;
import br.com.farmacia.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/client")
public class ClienteResource implements Serializable {

    @Autowired
    ClienteService clienteService;

    @Autowired
    EnderecoService enderecoService;


    //CREATE
    @PostMapping(path = "/create")
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel cliente){
        enderecoService.create(cliente.getEndereco());
        clienteService.create(cliente);
        return ResponseEntity.ok().build();
    }

    //READ
    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<ClienteModel> findById(@PathVariable Long id) throws AccountNotFoundException {
        ClienteModel found = clienteService.buscarId(id);
        return ResponseEntity.ok().body(found);
    }

    //READ
    @GetMapping(path = "/findall")
    public ResponseEntity<List<ClienteModel>>  findAll(){
        List<ClienteModel> found =  clienteService.buscarTodos();
       return ResponseEntity.ok().body(found);
    }


    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<ClienteModel> updateCliente(@RequestBody ClienteModel cliente, @PathVariable Long id) throws AccountNotFoundException {
        cliente.setId(id);
        EnderecoModel enderecoModel = enderecoService.update(cliente.getEndereco());

        cliente.setEndereco(enderecoModel);

        clienteService.update(cliente);

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteModel> deleteClient(@PathVariable Long id) throws AccountNotFoundException{
               ClienteModel clienteModel = clienteService.buscarId(id);
                       clienteService.deleteClientForId(id);
       enderecoService.deleteClientForId(clienteModel.getEndereco().getId());
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}
