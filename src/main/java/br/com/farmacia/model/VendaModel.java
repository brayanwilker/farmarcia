package br.com.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_venda")
@SequenceGenerator(name = "sq_venda", initialValue = 1, allocationSize = 1)
public class VendaModel implements Serializable {


    @Id
    @GeneratedValue(generator = "sq_venda",strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id;

    private String nomeProduto;

    private Date compra;

    private Double valor;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "funcionario_id")
    private FuncionarioModel funcionario;

    public VendaModel() {
    }

    public VendaModel(Long id, String nomeProduto, Date compra, Double valor) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.compra = compra;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Date getCompra() {
        return compra;
    }

    public void setCompra(Date compra) {
        this.compra = compra;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
}
