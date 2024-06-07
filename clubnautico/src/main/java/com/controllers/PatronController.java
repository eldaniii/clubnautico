package com.controllers;

import com.models.Patron;
import com.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrones")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrones() {
        return patronService.getAllPatrones();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable Integer id) {
        return patronService.getPatronById(id);
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        return patronService.savePatron(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable Integer id, @RequestBody Patron patron) {
        Patron patronTmp = patronService.getPatronById(id);
        patronTmp.setNombre(patron.getNombre());
        patronTmp.setDni(patron.getDni());
        patronTmp.setEmail(patron.getEmail());
        patronTmp.setTelefono(patron.getTelefono());
        patronTmp.setLicencia(patron.getLicencia());
        return patronService.savePatron(patronTmp);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Integer id) {
        patronService.deletePatron(id);
    }
}
