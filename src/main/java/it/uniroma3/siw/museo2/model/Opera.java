package it.uniroma3.siw.museo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opera")
public class Opera {
    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno")
    private Long anno;

    @Column(name = "descrizione")
    private String descrizione;

    @Id
    @Column(name = "artista")
    private String artista;

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Long getAnno() {
        return this.anno;
    }

    public void setAnno(Long anno) {
        this.anno = anno;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getArtista() {
        return this.artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
