package com.controllers;

import com.models.Barco;
import com.services.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barcos")
public class BarcoController {

    @Autowired
    private BarcoService barcoService;

    @GetMapping
    public List<Barco> getAllBarcos() {
        return barcoService.getAllBarcos();
    }

    @GetMapping("/{id}")
    public Barco getBarcoById(@PathVariable Integer id) {
        return barcoService.getBarcoById(id);
    }

    @PostMapping
    public Barco createBarco(@RequestBody Barco barco) {
        return barcoService.saveBarco(barco);
    }

    @PutMapping("/{id}")
    public Barco updateBarco(@PathVariable Integer id, @RequestBody Barco barco) {
        Barco barcoTmp = barcoService.getBarcoById(id);
        barcoTmp.setNombre(barco.getNombre());
        barcoTmp.setMatricula(barco.getMatricula());
        barcoTmp.setCuota(barco.getCuota());
        barcoTmp.setSocio(barco.getSocio());
        barcoTmp.setPatron(barco.getPatron());
        return barcoService.saveBarco(barcoTmp);
    }

    @DeleteMapping("/{id}")
    public void deleteBarco(@PathVariable Integer id) {
        barcoService.deleteBarco(id);
    }
}
