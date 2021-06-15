package it.uniroma3.siw.museo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "luogo_nascita")
    private String luogoNascita;

    @Column(name = "data_nascita")
    private Long dataNascita;

    @Column(name = "luogo_morte")
    private String luogoMorte;

    @Column(name = "data_morte")
    private Long dataMorte;

    @Column(name = "natzionalita")
    private String natzionalita;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLuogoNascita() {
        return this.luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public Long getDataNascita() {
        return this.dataNascita;
    }

    public void setDataNascita(Long dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoMorte() {
        return this.luogoMorte;
    }

    public void setLuogoMorte(String luogoMorte) {
        this.luogoMorte = luogoMorte;
    }

    public Long getDataMorte() {
        return this.dataMorte;
    }

    public void setDataMorte(Long dataMorte) {
        this.dataMorte = dataMorte;
    }

    public String getNatzionalita() {
        return this.natzionalita;
    }

    public void setNatzionalita(String natzionalita) {
        this.natzionalita = natzionalita;
    }
}

