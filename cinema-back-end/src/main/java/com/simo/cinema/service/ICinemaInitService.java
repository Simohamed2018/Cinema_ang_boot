package com.simo.cinema.service;

import org.springframework.stereotype.Service;


public interface ICinemaInitService {
// Partie static
    public void initVilles();
    public void initCinemas();
    public void initSalles();
    public void initPlaces();
    // Partie dynamique
    public void initCategorieFilms();
    public void initFilms();
    public void initSeances() throws Exception;
    public void initProjectionFilms();
    public void initTickects();

}
