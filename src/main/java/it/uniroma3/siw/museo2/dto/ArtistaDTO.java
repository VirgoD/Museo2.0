package it.uniroma3.siw.museo2.dto;

public class ArtistaDTO {
    String id;
    String nome;
    String ltuogoNascita;
    Long dataNascita;
    String luogoMorte;
    Long dataMorte;
    String natzionalita;

    public ArtistaDTO(String id, String nome, String ltuogoNascita, Long dataNascita,
                      String luogoMorte, Long dataMorte, String natzionalita) {
        this.id = id;
        this.nome = nome;
        this.ltuogoNascita = ltuogoNascita;
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

    public String getLtuogoNascita() {
        return ltuogoNascita;
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
