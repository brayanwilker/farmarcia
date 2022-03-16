package br.com.farmacia.model;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "tb_pessoa")
@SequenceGenerator(name = "sq_pessoa", allocationSize = 1, initialValue = 1)
public class PessoaModel {

    @Id
    @GeneratedValue(generator = "sq_pessoa", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pessoa")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tb_endereco")
    private EnderecoModel endereco;

    @Column(name = "dt_nascimento")
    private Date dtNascimento;

    @Column(name = "cpf_pessoa")
    private String cpf;

    @Column(name = "tel_telefone")
    private String telefone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
