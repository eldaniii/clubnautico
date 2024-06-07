package com.controllers;

import com.models.Salida;
import com.services.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salidas")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;

    @GetMapping
    public List<Salida> getAllSalidas() {
        return salidaService.getAllSalidas();
    }

    @GetMapping("/{id}")
    public Salida getSalidaById(@PathVariable Integer id) {
        return salidaService.getSalidaById(id);
    }

    @PostMapping
    public Salida createSalida(@RequestBody Salida salida) {
        return salidaService.saveSalida(salida);
    }

    @PutMapping("/{id}")
    public Salida updateSalida(@PathVariable Integer id, @RequestBody Salida salida) {
        Salida salidaTmp = salidaService.getSalidaById(id);
        salidaTmp.setFecha(salida.getFecha());
        salidaTmp.setBarco(salida.getBarco());
        salidaTmp.setPatron(salida.getPatron());
        return salidaService.saveSalida(salidaTmp);
    }

    @DeleteMapping("/{id}")
    public void deleteSalida(@PathVariable Integer id) {
        salidaService.deleteSalida(id);
    }
}
