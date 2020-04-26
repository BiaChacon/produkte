package com.biachacon.produkte.resources;

import com.biachacon.produkte.models.Produkt;
import com.biachacon.produkte.repositories.ProduktRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produkte")
@CrossOrigin(origins = "*")
public class ProduktResource {

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping("produkte")
    @ApiOperation(value = "Gibt eine Produktliste zurück")
    public List<Produkt>  findAll(){
        return produktRepository.findAll();
    }

    @GetMapping("produkt/{id}")
    @ApiOperation(value = "Gibt ein einzigartiges Produkt zurück")
    public Produkt findById(
            @ApiParam("ID eines registrierten Produkts")
            @PathVariable(value = "id") long id){
        return produktRepository.findById(id);
    }

    @PostMapping("/produkt")
    @ApiOperation(value = "Produkt registrieren")
    public Produkt save(
            @ApiParam("Produkt objekt")
            @RequestBody Produkt produkt){
        return produktRepository.save(produkt);
    }

    @DeleteMapping("/produkt")
    @ApiOperation(value = "Produkt löschen")
    public void delete(
            @ApiParam("Produkt objekt")
            @RequestBody Produkt produkt){
        produktRepository.delete(produkt);
    }

    @PutMapping("/produkt")
    @ApiOperation(value = "Produkt aktualisieren")
    public Produkt update(
            @ApiParam("Produkt objekt")
            @RequestBody Produkt produkt){
        return produktRepository.save(produkt);
    }

}
