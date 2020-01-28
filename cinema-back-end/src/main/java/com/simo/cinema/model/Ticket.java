package com.simo.cinema.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Data @NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotEmpty(message="le nom du client est obligatoire !")
    private String nomClient ;
   // @Min( value = 0,message="le nombre de place  dans la salle est obligatoire")
    private int codePayement;
  //  @Min( value = 0,message="le prix du ticket  est obligatoire")
    private double prix;
    private boolean reserver;
    @ManyToOne

    private ProjectionFilm projectionFilm;
    @ManyToOne
    private Place place;

}
