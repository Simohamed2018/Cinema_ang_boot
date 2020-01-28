package com.simo.cinema.controller;

import com.simo.cinema.dto.TicketForm;
import com.simo.cinema.model.Film;
import com.simo.cinema.model.Ticket;
import com.simo.cinema.repo.TicketRepository;
import com.simo.cinema.service.PhotoFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotoFilmController {
    @Autowired
    private PhotoFilmService  photoFilmService;


    @GetMapping("/listFilms")
    public List<Film> listeDesProduits() {
        List<Film> films = photoFilmService.getFilms();
        return films;
    }

    @GetMapping(path = "/imageFilm/{idFilm}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFim(@PathVariable(name="idFilm") long idFilm) throws  Exception{
        Film film=photoFilmService.getFilm(idFilm);
        String nomPhotoFilm = film.getNomPhoto();
        File file = new File(System.getProperty("user.home")+"/cinemaImages/images/"+nomPhotoFilm);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    @PostMapping("/payerTickets")
    public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm){

        return photoFilmService.payerTicket(ticketForm);
    }

}
