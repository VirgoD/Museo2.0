package it.uniroma3.siw.museo2.service;

import it.uniroma3.siw.museo2.dto.OperaDTO;
import it.uniroma3.siw.museo2.repository.OperaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperaService {
    private OperaRepository operaRepository;

    public OperaService(OperaRepository operaRepository) {
        this.operaRepository = operaRepository;
    }

    /*Query opere*/
    public List<OperaDTO> getOpere() {
        return this.operaRepository.getOpere()
                .stream()
                .map(entry -> new OperaDTO(
                        entry.getTitolo(),
                        entry.getAnno(),
                        entry.getDescrizione(),
                        entry.getArtista()
                )).collect(Collectors.toList());
    }

    public List<OperaDTO> getOperaSpecifica(String titolo) {
        return this.operaRepository.getOperaSpecifica(titolo)
                .stream()
                .map(entry -> new OperaDTO(
                        entry.getTitolo(),
                        entry.getAnno(),
                        entry.getDescrizione(),
                        entry.getArtista()
                )).collect(Collectors.toList());
    }

}
