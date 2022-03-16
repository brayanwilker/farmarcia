package br.com.farmacia.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id_cliente")
@Table(name = "tb_cliente")
public class ClienteModel extends PessoaModel{

    @Column(name = "convenio")
    private boolean convenio;


}
