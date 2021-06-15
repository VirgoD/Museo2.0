package it.uniroma3.siw.museo2.service;

import it.uniroma3.siw.museo2.dto.CollezioneDTO;
import it.uniroma3.siw.museo2.repository.CollezioneRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CollezioneService {

    private CollezioneRepository collezioneRepository;

    public CollezioneService(CollezioneRepository collezioneRepository) {
        this.collezioneRepository = collezioneRepository;
    }

    /*QUery collezione*/
    public List<CollezioneDTO> getCollezione() {
        return this.collezioneRepository.getCollezioni()
                .stream()
                .map(entry -> new CollezioneDTO(
                        entry.getTitolo(),
                        entry.getAnno(),
                        entry.getDescrizione(),
                        entry.getCuratore_Id()
                )).collect(Collectors.toList());
    }

    public List<CollezioneDTO> getCollezioneSpecifica(String titolo) {
        return this.collezioneRepository.getSpecificaCollezione(titolo)
                .stream()
                .map(entry -> new CollezioneDTO(
                        entry.getTitolo(),
                        entry.getAnno(),
                        entry.getDescrizione(),
                        entry.getCuratore_Id()
                )).collect(Collectors.toList());
    }

}
