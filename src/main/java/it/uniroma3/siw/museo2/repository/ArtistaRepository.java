package it.uniroma3.siw.museo2.repository;

import it.uniroma3.siw.museo2.entity.ArtistaInterface;
import it.uniroma3.siw.museo2.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista,String>, JpaSpecificationExecutor<Artista> {

    @Query(value = "SELECT * FROM artisti.artista", nativeQuery = true)
    public List<ArtistaInterface> getArtista();

    @Query(value = "SELECT * FROM artisti.artista WHERE artista.nome like :nome%", nativeQuery = true)
    public List<ArtistaInterface> getSpecificoArtista(@Param("nome") String nome);

    @Query(value = "INSERT INTO artisti.artista (id, nome, luogo_nascita, data_nascita, luogo_morte, data_morte, natzionalita) \n" +
            "VALUES (:id, :nome, :luogo_nascita, :data_nascita, :luogo_morte, :data_morte, :natzionalita)", nativeQuery = true)
    public List<ArtistaInterface> addArtista(@Param("id") String id,
                                             @Param("nome") String nome,
                                             @Param("luogo_nascita") String luogoNascita,
                                             @Param("data_nascita") Long dataNascita,
                                             @Param("luogo_morte") String luogoMorte,
                                             @Param("data_morte") Long dataMorte,
                                             @Param("natzionalita") String nazionalita);

    @Query(value = "DELETE FROM artisti.artista WHERE artista.id = :id ", nativeQuery = true)
    public List<ArtistaInterface> deleteArtista(@Param("id") String id);

    @Query(value = ")", nativeQuery = true)
    public List<ArtistaInterface> modifyArtista(@Param("id") String id,
                                             @Param("nome") String nome,
                                             @Param("luogo_nascita") String luogoNascita,
                                             @Param("data_nascita") Long dataNascita,
                                             @Param("luogo_morte") String luogoMorte,
                                             @Param("data_morte") Long dataMorte,
                                             @Param("natzionalita") String nazionalita);

}
