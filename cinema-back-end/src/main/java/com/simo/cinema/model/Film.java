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
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  @NotEmpty(message="le titre ne peux pas etre null")
    private String nomFilm;
    @JsonIgnore
   // @Length(min=3, max=100, message ="description doit etre entre 3 et 20 caracteres")
    private String description;
    private Date dateSortie;
   // @Min( value = 0,message="la dure du film en heure est obligatoire")
    private double dureeFilmEnHeure;
    private String realisateur;
    private String nomPhoto;
    @ManyToOne
    private CategorieFilm categorie;
    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ProjectionFilm> projectionsFilms;



}
