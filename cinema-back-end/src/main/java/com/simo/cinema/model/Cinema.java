package com.simo.cinema.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity (name="cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotEmpty(message="le nom du cinema ne doit pas etre null")
    private String nomCinema;
    @Column(length = 100)
   // @Length(min=3, max=100, message ="description doit etre entre 3 et 20 caracteres")
    private String description;
   // @Min( value = 0,message="le nombre de salle dans le cinema  est obligatoire")
    private int nombreDeSalle;
    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;

}
