package it.uniroma3.siw.museo2.dto;

public class OperaDTO {
    String titolo;
    Long anno;
    String descrizione;
    String artista;

    public OperaDTO(String titolo, Long anno, String descrizione, String artista) {
        this.titolo = titolo;
        this.anno = anno;
        this.descrizione = descrizione;
        this.artista = artista;
    }

    public String getTitolo() {
        return titolo;
    }

    public Long getAnno() {
        return anno;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getArtista() {
        return artista;
    }
}
