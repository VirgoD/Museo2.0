package it.uniroma3.siw.museo2.controller;

import it.uniroma3.siw.museo2.dto.ArtistaDTO;
import it.uniroma3.siw.museo2.dto.CollezioneDTO;
import it.uniroma3.siw.museo2.service.CollezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CollezioneController {

    @Autowired
    CollezioneService collezioneService;

    @GetMapping(path ="/collezioni")
    public List<CollezioneDTO> getCollezioni(){ return this.collezioneService.getCollezione(); }

    @GetMapping(path ="/collezioneSpecifico")
    public List<CollezioneDTO> getSpecificaCollezione(@RequestParam String titolo){ return this.collezioneService
            .getCollezioneSpecifica(titolo); }

    @GetMapping(path ="/addCollezione")
    public  List<CollezioneDTO> addCollection(@RequestParam String titolo,
                                                @RequestParam Long anno,
                                                @RequestParam String descrizione,
                                                @RequestParam String curatoreId)
    {return this.collezioneService.addCollection(titolo,anno,descrizione,curatoreId); }
}
