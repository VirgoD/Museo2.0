package it.uniroma3.siw.museo2.dto;

public class CollezioneDTO {
    String titolo;
    Long anno;
    String descrizione;
    String curatoreId;

    public CollezioneDTO(String titolo, Long anno, String descrizione, String curatoreId) {
        this.titolo = titolo;
        this.anno = anno;
        this.descrizione = descrizione;
        this.curatoreId = curatoreId;
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

    public String getCuratoreId() {
        return curatoreId;
    }
}
