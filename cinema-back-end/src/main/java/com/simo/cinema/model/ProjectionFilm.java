package com.simo.cinema.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name="projection")
public class ProjectionFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotEmpty(message="le titre ne peux pas etre null")
    private String nomProjectionFilm;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// pour eviter la lecture en va et viens avec la salle
    private Salle salle ;
    @ManyToOne
    private Film film;
    @ManyToOne
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Seance seance;
    @OneToMany(mappedBy = "projectionFilm")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;



}
