package com.controllers;

import com.models.Socio;
import com.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping("findAllSocios/{id}")
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public Socio getSocioById(@PathVariable Integer id) {
        return socioService.getSocioById(id);
    }

    @PostMapping()
    public Socio createSocio(@RequestBody Socio socio) {
        return socioService.saveSocio(socio);
    }

    @PutMapping("/{id}")
    public Socio updateSocio(@PathVariable Integer id, @RequestBody Socio socio) {
        Socio socioTmp = socioService.getSocioById(id);
        socioTmp.setNombre(socio.getNombre());
        socioTmp.setDni(socio.getDni());
        socioTmp.setEmail(socio.getEmail());
        socioTmp.setTelefono(socio.getTelefono());
        return socioService.saveSocio(socioTmp);
    }

    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable Integer id) {
        socioService.deleteSocio(id);
    }
}
