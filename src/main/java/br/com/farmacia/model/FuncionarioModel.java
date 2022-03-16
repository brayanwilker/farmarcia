package br.com.farmacia.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id_funcionario")
@Table(name = "tb_funcionario")
public class FuncionarioModel extends PessoaModel{

    @Column(name = "cargo_pessoa_funcionario")
    private String cargo;

    @Column(name = "salario_pessoa_funcionario")
    private double salario;

    @Column(name = "comissao_pessoa_funcionario")
    private double comissao;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
    private List<VendaModel> venda = new ArrayList<>();

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public List<VendaModel> getVenda() {
        return venda;
    }

    public void setVenda(List<VendaModel> venda) {
        this.venda = venda;
    }
}
