package com.meudominio.projetoapirest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * A ‘@Entity’ informa ao JPA que essa classe se trata de uma entidade JPA.
 * A ‘@Table’ é opcional, e permite definir o nome da tabela no banco de dados para a
 * entidade.
 *
 * A ‘@Id’ informa que o campo será a chave primária da tabela.
 *
 * A ‘@GeneratedValue’ informa como a chave primária será incrementada, sendo que o
 * modo automático apenas incrementará o valor em 1 a cada nova inserção.
 *
 * A ‘@Column’ permite definir um nome para o campo na tabela do banco de dados, assim
 * como se ele pode ou não ser nulo.
 *
 * As ‘@PrePersist’ e ‘@PreUpdate’ também são opcionais, e permitem executar uma ação
 * antes de uma inserção ou atualização de um registro.
 *
 * */

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 3960436649365666213L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;

    public Empresa() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
