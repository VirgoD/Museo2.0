package it.uniroma3.siw.museo2.controller;

import it.uniroma3.siw.museo2.dto.OperaDTO;
import it.uniroma3.siw.museo2.service.OperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OperaController {

    @Autowired
    OperaService operaService;


    @GetMapping(path ="/opere")
    public List<OperaDTO> getOpere(){ return this.operaService.getOpere(); }

    @GetMapping(path ="/operaSpeficifa")
    public List<OperaDTO> getSpecificaOpera(@RequestParam String titolo){ return this.operaService.getOperaSpecifica(titolo); }
}
