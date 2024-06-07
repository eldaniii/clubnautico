package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "barco_id")
    private Barco barco;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

}
