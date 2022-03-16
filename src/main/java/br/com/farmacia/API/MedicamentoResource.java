package br.com.farmacia.API;

import br.com.farmacia.model.ClienteModel;
import br.com.farmacia.model.EnderecoModel;
import br.com.farmacia.model.MedicamentoModel;
import br.com.farmacia.model.MedicamentoModel;
import br.com.farmacia.service.MedicamentoService;
import br.com.farmacia.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/medicine")
public class MedicamentoResource implements Serializable {

    @Autowired
    MedicamentoService medicamentoService;

    //CREATE
    @PostMapping(path = "/create")
    public ResponseEntity<MedicamentoModel> create(@RequestBody MedicamentoModel medicamento) {
        medicamentoService.create(medicamento);
        return ResponseEntity.ok().build();
    }

    //READ
    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<MedicamentoModel> findById(@PathVariable Long id) throws AccountNotFoundException {
        MedicamentoModel found = medicamentoService.buscarId(id);
        return ResponseEntity.ok().body(found);
    }

    //READ
    @GetMapping(path = "/findall")
    public ResponseEntity<List<MedicamentoModel>> findAll() {
        List<MedicamentoModel> found = medicamentoService.buscarTodos();
        return ResponseEntity.ok().body(found);
    }


    //UPDATE
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<MedicamentoModel> updateMedicine(@RequestBody MedicamentoModel medicamentoModel, @PathVariable Long id) throws AccountNotFoundException {
        medicamentoModel.setId(id);


        medicamentoService.update(medicamentoModel);

        return ResponseEntity.status(HttpStatus.OK).body(medicamentoModel);
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MedicamentoModel> deleteMedicine(@PathVariable Long id) throws AccountNotFoundException {
        medicamentoService.deleteMedicineForId(id);
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}
