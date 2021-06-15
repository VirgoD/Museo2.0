package it.uniroma3.siw.museo2.controller;

import it.uniroma3.siw.museo2.dto.CollezioneDTO;
import it.uniroma3.siw.museo2.service.CollezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CollezioneController {

    @Autowired
    CollezioneService collezioneService;

    @GetMapping(path ="/collezioni")
    public List<CollezioneDTO> getCollezioni(){ return this.collezioneService.getCollezione(); }

    @GetMapping(path ="/collezioneSpecifico")
    public List<CollezioneDTO> getSpecificaCollezione(@RequestParam String titolo){ return this.collezioneService
            .getCollezioneSpecifica(titolo); }

}
