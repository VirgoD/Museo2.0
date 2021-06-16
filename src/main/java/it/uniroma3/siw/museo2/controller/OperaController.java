package it.uniroma3.siw.museo2.controller;

import it.uniroma3.siw.museo2.dto.CollezioneDTO;
import it.uniroma3.siw.museo2.dto.OperaDTO;
import it.uniroma3.siw.museo2.service.OperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class OperaController {

    @Autowired
    OperaService operaService;


    @GetMapping(path ="/opere")
    public List<OperaDTO> getOpere(){ return this.operaService.getOpere(); }

    @GetMapping(path ="/operaSpeficifa")
    public List<OperaDTO> getSpecificaOpera(@RequestParam String titolo){ return this.operaService.getOperaSpecifica(titolo); }

    @GetMapping(path ="/addOpera")
    public  List<OperaDTO> addOpera(@RequestParam String titolo,
                                    @RequestParam Long anno,
                                    @RequestParam String descrizione,
                                    @RequestParam String artista)
    {return this.operaService.addOpera(titolo,anno,descrizione,artista); }
}
