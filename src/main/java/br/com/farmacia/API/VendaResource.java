package br.com.farmacia.API;


import br.com.farmacia.model.VendaModel;
import br.com.farmacia.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/compras")
public class VendaResource implements Serializable {

    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<List<VendaModel>> findAll() {
        List<VendaModel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


//    @PostMapping("/create")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<VendaModel> novoCompra(@RequestBody VendaModel venda) {
//        service.createvenda(venda);
//        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
//    }


    @GetMapping(value = "/read/{id}")
    public ResponseEntity<VendaModel> findById(@PathVariable Long id) {
        VendaModel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


//    @PutMapping("/update/{id}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<VendaModel> updateCompra(@RequestBody VendaModel venda, @PathVariable Long id) {
//        VendaModel venda = service.findById(id);
//        if(venda == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(venda);
//        }
//        if(venda.getCompra() != null){
//            venda.setCompra(venda.getCompra());
//        }
//        if(venda.getValor() != null){
//            venda.setValor(venda.getValor());
//        }
//        if(compra.getNomeProduto() != null){
//            venda.setNomeProduto(venda.getNomeProduto());
//        }
//
//        service.createCompra(compra1);
//        return ResponseEntity.status(HttpStatus.OK).body(compra1);
//    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VendaModel> deleteCompra(@PathVariable Long id) {
        VendaModel venda = service.findById(id);
        if(service.deleteVendaById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(venda);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(venda);
        }
    }
}
