package com.services;

import com.exceptions.DuplicatedException;
import com.exceptions.NotFoundException;
import com.models.Salida;
import com.repositories.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalidaService {

    @Autowired
    private SalidaRepository salidaRepository;

    public List<Salida> getAllSalidas() {
        return salidaRepository.findAll();
    }

    public Salida getSalidaById(int id) {
        return salidaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado la salida con id " + id));
    }

    public Salida saveSalida(Salida salida) {
        if (salidaRepository.existsById(salida.getId())) {
            throw new DuplicatedException("La salida con id ya existe " + salida.getId());
        }
        return salidaRepository.save(salida);
    }

    public Salida updateSalida(int id, Salida salida) {
        Salida salidaTmp = getSalidaById(id);
        salidaTmp.setFecha(salida.getFecha());
        salidaTmp.setBarco(salida.getBarco());
        salidaTmp.setPatron(salida.getPatron());
        return salidaRepository.save(salidaTmp);
    }

    public void deleteSalida(int id) {
        if (!salidaRepository.existsById(id)) {
            throw new NotFoundException("No se ha encontrado la salida con id " + id);
        }
        salidaRepository.deleteById(id);
    }
}
