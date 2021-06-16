package it.uniroma3.siw.museo2.repository;

import it.uniroma3.siw.museo2.entity.CollezioneInterface;
import it.uniroma3.siw.museo2.model.Opera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface OperaRepository extends JpaRepository<Opera,String>, JpaSpecificationExecutor<Opera> {

    @Query(value = "SELECT * FROM opere.opera", nativeQuery = true)
    List<Opera> getOpere();

    @Query(value = "SELECT * FROM opere.opera WHERE opera.titolo like :titolo%", nativeQuery = true)
    List<Opera> getOperaSpecifica(String titolo);

    @Query(value = "insert into opere.opera(titolo, anno, descrizione, artista) " +
            "VALUES(:titolo,:anno, :descrizione, :artista) ", nativeQuery = true)
    public List<Opera> addOpera(@Param("titolo") String titolo,
                                                   @Param("anno") Long anno,
                                                   @Param("descrizione") String descrizione,
                                                   @Param("artista")String artista);
}
