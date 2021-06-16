package it.uniroma3.siw.museo2.service;

import it.uniroma3.siw.museo2.dto.ArtistaDTO;
import it.uniroma3.siw.museo2.model.Artista;
import it.uniroma3.siw.museo2.repository.ArtistaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ArtistaService {

    private ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    /*Query artista*/
    public List<ArtistaDTO> getArtisti() {
        return this.artistaRepository.getArtista()
                .stream()
                .map(entry -> new ArtistaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getLuogo_Nascita(),
                        entry.getData_nascita(),
                        entry.getNatzionalita(),
                        entry.getData_morte(),
                        entry.getLuogo_morte()
                )).collect(Collectors.toList());

    }

    public List<ArtistaDTO> getSpecificoArtista(String nome) {
        return this.artistaRepository.getSpecificoArtista(nome)
                .stream()
                .map(entry -> new ArtistaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getLuogo_Nascita(),
                        entry.getData_nascita(),
                        entry.getNatzionalita(),
                        entry.getData_morte(),
                        entry.getLuogo_morte()
                )).collect(Collectors.toList());
    }

    public List<ArtistaDTO> addArtista(String id, String nome, String luogoNascita,
                                       Long dataNascita, String luogoMorte,
                                       Long dataMorte, String nazionalita) {
        return this.artistaRepository.addArtista(id,nome, luogoNascita, dataNascita, luogoMorte, dataMorte, nazionalita)
                .stream()
                .map(entry -> new ArtistaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getLuogo_Nascita(),
                        entry.getData_nascita(),
                        entry.getNatzionalita(),
                        entry.getData_morte(),
                        entry.getLuogo_morte()
                )).collect(Collectors.toList());
    }

    public List<ArtistaDTO> deleteArtista(String id) {
        return this.artistaRepository.deleteArtista(id)
                .stream()
                .map(entry -> new ArtistaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getLuogo_Nascita(),
                        entry.getData_nascita(),
                        entry.getNatzionalita(),
                        entry.getData_morte(),
                        entry.getLuogo_morte()
                )).collect(Collectors.toList());
    }
}
