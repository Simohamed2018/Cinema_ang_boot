package com.simo.cinema.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name="Categorie")
public class CategorieFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotEmpty(message="le titre ne peux pas etre null")
    private String nomCategorie;
    @JsonIgnore
   // @Length(min=3, max=100, message ="description doit etre entre 3 et 20 caracteres")
    private String description;
    @OneToMany(mappedBy = "categorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //pour corriger le bouclage infifni si on utilie rest controller
    private Collection<Film> films;

}
