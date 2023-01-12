package com.co.softcaribbean.facturaelectronica.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@ToString
@EqualsAndHashCode
public class Paciente {


   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Getter @Setter
   private Long id;

   @Getter @Setter
   private LocalDate fecRegistro;

   @OneToOne(cascade =  CascadeType.REFRESH)
   @Getter @Setter
   private Mascota mascota;




}
