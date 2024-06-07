package com.services;

import com.exceptions.DuplicatedException;
import com.exceptions.NotFoundException;
import com.models.Barco;
import com.repositories.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    public List<Barco> getAllBarcos() {
        return barcoRepository.findAll();
    }

    public Barco getBarcoById(int id) {
        return barcoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el barco con id " + id));
    }

    public Barco saveBarco(Barco barco) {
        if (barcoRepository.existsById(barco.getId())) {
            throw new DuplicatedException("El barco con id " + barco.getId() + " ya existe");
        }
        return barcoRepository.save(barco);
    }

    public Barco updateBarco(int id, Barco barco) {
        Barco barcoTmp = getBarcoById(id);
        barcoTmp.setNombre(barco.getNombre());
        barcoTmp.setMatricula(barco.getMatricula());
        barcoTmp.setCuota(barco.getCuota());
        barcoTmp.setSocio(barco.getSocio());
        barcoTmp.setPatron(barco.getPatron());
        return barcoRepository.save(barcoTmp);
    }

    public void deleteBarco(int id) {
        if (!barcoRepository.existsById(id)) {
            throw new NotFoundException("No se ha encontrado el barcon con id " + id);
        }
        barcoRepository.deleteById(id);
    }
}
