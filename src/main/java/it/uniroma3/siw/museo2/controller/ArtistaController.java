package it.uniroma3.siw.museo2.controller;

import it.uniroma3.siw.museo2.dto.ArtistaDTO;
import it.uniroma3.siw.museo2.service.ArtistaService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;

    @GetMapping(path = "/artisti")
    public List<ArtistaDTO> artisti(){ return this.artistaService.getArtisti(); }

    @GetMapping(path ="/artistaSpecifico")
    public List<ArtistaDTO> getSpecificoArtista(@RequestParam String nome){ return this.artistaService.getSpecificoArtista(nome); }

    @GetMapping(path = "/addArtista")
    public  List<ArtistaDTO> addArtista(@RequestParam String id,
                                        @RequestParam String nome,
                                        @RequestParam String luogoNascita,
                                        @RequestParam Long dataNascita,
                                        @RequestParam(required = false) String luogoMorte,
                                        @RequestParam(required = false) Long dataMorte,
                                        @RequestParam String nazionalita)
    {return this.artistaService.addArtista(id,nome,luogoNascita, dataNascita, luogoMorte, dataMorte, nazionalita); }
}
