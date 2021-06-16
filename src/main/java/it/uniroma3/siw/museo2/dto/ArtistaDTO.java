package it.uniroma3.siw.museo2.dto;

public class ArtistaDTO {
    String id;
    String nome;
    String luogoNascita;
    Long dataNascita;
    String luogoMorte;
    Long dataMorte;
    String natzionalita;

    public ArtistaDTO(String id, String nome, String luogoNascita, Long dataNascita,
                      String luogoMorte, Long dataMorte, String natzionalita) {
        this.id = id;
        this.nome = nome;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.luogoMorte = luogoMorte;
        this.dataMorte = dataMorte;
        this.natzionalita = natzionalita;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public Long getDataNascita() {
        return dataNascita;
    }

    public String getLuogoMorte() {
        return luogoMorte;
    }

    public Long getDataMorte() {
        return dataMorte;
    }

    public String getNatzionalita() {
        return natzionalita;
    }
}
