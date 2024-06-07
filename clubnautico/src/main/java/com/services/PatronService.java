package com.services;

import com.exceptions.DuplicatedException;
import com.exceptions.NotFoundException;
import com.models.Patron;
import com.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrones() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(int id) {
        return patronRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el patrón con id " + id));
    }

    public Patron savePatron(Patron patron) {
        if (patronRepository.existsById(patron.getId())) {
            throw new DuplicatedException("El patrón con id " + patron.getId() + " ya existe");
        }
        return patronRepository.save(patron);
    }

    public Patron updatePatron(int id, Patron patron) {
        Patron patronTmp = getPatronById(id);
        patronTmp.setNombre(patron.getNombre());
        patronTmp.setDni(patron.getDni());
        patronTmp.setEmail(patron.getEmail());
        patronTmp.setTelefono(patron.getTelefono());
        patronTmp.setLicencia(patron.getLicencia());
        return patronRepository.save(patronTmp);
    }

    public void deletePatron(int id) {
        if (!patronRepository.existsById(id)) {
            throw new NotFoundException("No se ha encontrado el patrón con id " + id);
        }
        patronRepository.deleteById(id);
    }
}
