package com.co.softcaribbean.facturaelectronica.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString @EqualsAndHashCode
public class Cliente {


        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Getter @Setter
        private Long id;

        @Getter @Setter
        private String tipoId;

        @Getter @Setter
        private String numId;

        @Getter @Setter
        private String nombre;

        @Getter @Setter
        private String apellido;

        @Getter @Setter
        private String direccion;

        @Getter @Setter
        private String ciudad;

        @Getter @Setter
        private String telefono;

    }
