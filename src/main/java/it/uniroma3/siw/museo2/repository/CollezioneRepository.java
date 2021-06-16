package it.uniroma3.siw.museo2.repository;

import it.uniroma3.siw.museo2.entity.CollezioneInterface;
import it.uniroma3.siw.museo2.model.Collezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface CollezioneRepository extends JpaRepository<Collezione,String>, JpaSpecificationExecutor<Collezione> {

    @Query(value = "SELECT * FROM collezioni.collezione", nativeQuery = true)
    public List<CollezioneInterface> getCollezioni();

    @Query(value = "SELECT * FROM collezioni.collezione WHERE collezione.titolo like :titolo%", nativeQuery = true)
    public List<CollezioneInterface> getSpecificaCollezione(@Param("titolo") String titolo);

    @Query(value = "insert into collezioni.collezione(titolo, anno, descrizione, curatore_id) " +
            "VALUES(:titolo,:anno, :descrizione, :curatore_id) ", nativeQuery = true)
    public List<CollezioneInterface> addCollection(@Param("titolo") String titolo,
                                                     @Param("anno") Long anno,
                                                     @Param("descrizione") String descrizione,
                                                     @Param("curatore_id")String curatoreId);
}
