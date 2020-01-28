package com.simo.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;


@Data @NoArgsConstructor  @AllArgsConstructor
@Entity (name ="ville")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotEmpty(message="le titre ne peux pas etre null")
    private String nomVillee;
   @Column(length = 50)
   // @Length(min=3, max=100, message ="description doit etre entre 3 et 20 caracteres")
    private String description;
    private int nombreDeCinema;
    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;


}
