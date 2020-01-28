package com.simo.cinema;

import com.simo.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CinemaApplication implements CommandLineRunner {
	@Autowired
	ICinemaInitService	cinemaInitService;

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		// Partie dynamique
		cinemaInitService.initCategorieFilms();
		cinemaInitService.initFilms();
		cinemaInitService.initProjectionFilms();
		cinemaInitService.initTickects();

	}
}
