package br.com.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name = "sq_endereco", allocationSize = 1, initialValue = 1)
public class EnderecoModel {

    @Id
    @GeneratedValue(generator = "sq_endereco", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_endereco")
    private Long id;

    @Column(name = "log_endereco")
    private String logradouro;

    @Column(name = "num_endereco")
    private Integer numero;

    @Column(name = "cep_endereco")
    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
