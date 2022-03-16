package br.com.farmacia.model;

import br.com.farmacia.enums.TarjaEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_medicamento")
@SequenceGenerator(name = "sq_medicamento", initialValue = 1, allocationSize = 1)
public class MedicamentoModel {

    @Id
    @GeneratedValue(generator = "sq_medicamento", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_medicamento")
    private Long id;

    @Column(name = "tarja_medicamento")
    private TarjaEnum tarja;

    @Column(name = "nm_medicamento")
    private String nome;

    @Column(name = "validade_medicamento")
    private Date validade;

    @Column(name = "desc_medicamento")
    private String descrição;

    private double valor;

    public MedicamentoModel() {
        this.id = id;
        this.tarja = tarja;
        this.nome = nome;
        this.validade = validade;
        this.valor = valor;
    }

    public MedicamentoModel(Long id, TarjaEnum tarja, String nome, Date validade, String descrição, double valor) {
        this.id = id;
        this.tarja = tarja;
        this.nome = nome;
        this.validade = validade;
        this.descrição = descrição;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TarjaEnum getTarja() {
        return tarja;
    }

    public void setTarja(TarjaEnum tarja) {
        this.tarja = tarja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
