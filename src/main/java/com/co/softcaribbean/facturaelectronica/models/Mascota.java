package com.co.softcaribbean.facturaelectronica.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@ToString
@EqualsAndHashCode
public class Mascota {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    private String nomMascota;

    @Getter @Setter
    private String especieMascota;

    @Getter @Setter
    private String razaMascota;

    @Getter @Setter
    private LocalDate fecNacMascota;

    @Getter @Setter
    private String colorMascota;

    @Getter @Setter
    @ManyToOne(cascade =  CascadeType.REFRESH)
    private Cliente cliente;

    }


