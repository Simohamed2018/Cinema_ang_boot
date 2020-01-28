package com.simo.cinema.service;

import com.simo.cinema.dto.TicketForm;
import com.simo.cinema.model.Film;
import com.simo.cinema.model.Ticket;

import java.util.List;

public interface PhotoFilmService {

    public byte[] getPhotoFilm(long idFilm);
    public List<Film> getFilms();
    public Film getFilm(Long idFilm);
    public List<Ticket> payerTicket(TicketForm ticketForm);

}
