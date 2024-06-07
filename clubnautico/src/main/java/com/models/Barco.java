package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String matricula;
    private double cuota;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @JsonIgnore
    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL)
    private List<Salida> listaSalidas;

}
