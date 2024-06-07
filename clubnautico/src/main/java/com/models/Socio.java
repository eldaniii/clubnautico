package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Barco> barcos;

}
