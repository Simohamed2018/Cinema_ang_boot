package com.simo.cinema.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @NotEmpty(message="le titre ne peux pas etre null")
    private String titre;
    @JsonIgnore
    @Length(min=3, max=100, message ="description doit etre entre 3 et 20 caracteres")
    private String description;
    @JsonIgnore
    private String image;
    @Min( value = 1,message="le prix est obligatoire")
    private Double prix;
    @JsonIgnore
    @Min( value = 0,message="le prix est obligatoire")
    private Double vente;


    public Product() {
    }

    

    



	public Product(int id, @NotEmpty(message = "le titre ne peux pas etre null") String titre,
			@Length(min = 3, max = 100, message = "description doit etre entre 3 et 20 caracteres") String description,
			String image, @Min(value = 1, message = "le prix est obligatoire") Double prix,
			@Min(value = 0, message = "le prix est obligatoire") Double vente) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.prix = prix;
		this.vente = vente;
	}







	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
        

	public Double getVente() {
		return vente;
	}


	public void setVente(Double vente) {
		this.vente = vente;
	}


	@Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", titre='" + titre + '\'' +                
                ", prix=" + prix +
                '}';
    }


}
