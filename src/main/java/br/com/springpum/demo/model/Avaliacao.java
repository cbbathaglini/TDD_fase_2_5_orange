package br.com.springpum.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Deprecated
    public Avaliacao() {
    }

    public Avaliacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
