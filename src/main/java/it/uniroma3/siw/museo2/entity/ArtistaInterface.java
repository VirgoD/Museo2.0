package it.uniroma3.siw.museo2.entity;

import javax.persistence.Entity;

public interface ArtistaInterface {
    String getId();
    String getNome();
    String getLuogo_Nascita();
    Long getData_nascita();
    String getLuogo_morte();
    Long getData_morte();
    String getNatzionalita();
}
