package com.services;

import com.exceptions.DuplicatedException;
import com.exceptions.NotFoundException;
import com.models.Socio;
import com.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Socio getSocioById(int id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el socio con id " + id));
    }

    public Socio saveSocio(Socio socio) {
        if (socioRepository.existsById(socio.getId())) {
            throw new DuplicatedException("El socio con id " + socio.getId() + " ya existe");
        }
        return socioRepository.save(socio);
    }

    public Socio updateSocio(int id, Socio updatedSocio) {
        Socio socio = getSocioById(id);
        socio.setNombre(socio.getNombre());
        socio.setDni(socio.getDni());
        socio.setEmail(socio.getEmail());
        socio.setTelefono(socio.getTelefono());
        return socioRepository.save(socio);
    }

    public void deleteSocio(int id) {
        if (!socioRepository.existsById(id)) {
            throw new NotFoundException("No se ha encontrado el socio con id " + id);
        }
        socioRepository.deleteById(id);
    }
}
