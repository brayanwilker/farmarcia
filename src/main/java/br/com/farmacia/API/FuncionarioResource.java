package br.com.farmacia.API;

import br.com.farmacia.model.*;
import br.com.farmacia.service.EnderecoService;
import br.com.farmacia.service.FuncionarioService;
import br.com.farmacia.service.MedicamentoService;
import br.com.farmacia.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class FuncionarioResource implements Serializable {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    MedicamentoService medicamentoService;

    @Autowired
    VendaService vendaService;


    @PostMapping(path = "/create")
    public ResponseEntity<FuncionarioModel> create(@RequestBody FuncionarioModel funcionario) {
        enderecoService.create(funcionario.getEndereco());
        funcionarioService.create(funcionario);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<FuncionarioModel> findById(@PathVariable Long id) throws AccountNotFoundException {
        FuncionarioModel found = funcionarioService.buscarId(id);
        return ResponseEntity.ok().body(found);
    }

    @GetMapping(path = "/findall")
    public ResponseEntity<List<FuncionarioModel>> findAll() {
        List<FuncionarioModel> found = funcionarioService.buscarTodos();
        return ResponseEntity.ok().body(found);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<FuncionarioModel> updateEmployee(@RequestBody FuncionarioModel funcionario, @PathVariable Long id) throws AccountNotFoundException {

        EnderecoModel enderecoModel = enderecoService.update(funcionario.getEndereco());
        funcionario.setEndereco(enderecoModel);
        funcionario.setId(id);
        funcionarioService.update(funcionario);

        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FuncionarioModel> deleteEmployee(@PathVariable Long id) throws AccountNotFoundException {
        FuncionarioModel funcionarioModel = funcionarioService.buscarId(id);

        //VALIDAÇÃO PARA APAGAR ENDEREÇO
        EnderecoModel enderecoModel = new EnderecoModel();
        if(funcionarioModel.getEndereco() != null){
            enderecoModel = enderecoService.buscarId(funcionarioModel.getEndereco().getId());
            enderecoService.deleteClientForId(enderecoModel.getId());
        }

        //APAGAR LISTA DE VENDAS
        List<VendaModel> apagar = new ArrayList<>();
        apagar = funcionarioModel.getVenda();
        for(VendaModel c: apagar){
            vendaService.deleteVendaById(c.getId());
        }

        //DELETAR FUNCIONARIO
        funcionarioService.deleteEmployeeForId(id);
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(path = "/sale")
    @ResponseBody
    @ResponseStatus
    public ResponseEntity<FuncionarioModel> saleMedicine(@RequestParam Long idEmployee, @RequestParam Long idMedicine) throws AccountNotFoundException {


       MedicamentoModel found = medicamentoService.buscarId(idMedicine);
        FuncionarioModel funcionario = funcionarioService.buscarId(idEmployee);
       vendaService.createVenda(found, funcionario);
       funcionarioService.comissão(found, idEmployee);

       return ResponseEntity.ok().build();

    }
}
