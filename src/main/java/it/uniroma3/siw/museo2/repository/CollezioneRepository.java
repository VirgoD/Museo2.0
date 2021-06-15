package it.uniroma3.siw.museo2.repository;

import it.uniroma3.siw.museo2.entity.CollezioneInterface;
import it.uniroma3.siw.museo2.model.Collezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollezioneRepository extends JpaRepository<Collezione,String>, JpaSpecificationExecutor<Collezione> {

    @Query(value = "SELECT * FROM collezioni.collezione", nativeQuery = true)
    public List<CollezioneInterface> getCollezioni();

    @Query(value = "SELECT * FROM collezioni.collezione WHERE collezione.titolo like :titolo%", nativeQuery = true)
    public List<CollezioneInterface> getSpecificaCollezione(@Param("titolo") String titolo);
}
