package it.uniroma3.siw.museo2.repository;

import it.uniroma3.siw.museo2.model.Opera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperaRepository extends JpaRepository<Opera,String>, JpaSpecificationExecutor<Opera> {

    @Query(value = "SELECT * FROM opere.opera", nativeQuery = true)
    List<Opera> getOpere();

    @Query(value = "SELECT * FROM opere.opera WHERE opera.tiolo like :titolo%", nativeQuery = true)
    List<Opera> getOperaSpecifica(String titolo);

}
