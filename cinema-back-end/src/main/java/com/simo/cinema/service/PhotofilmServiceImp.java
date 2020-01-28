package com.simo.cinema.service;

import com.simo.cinema.dto.TicketForm;
import com.simo.cinema.model.Film;
import com.simo.cinema.model.Ticket;
import com.simo.cinema.repo.FilmRepository;
import com.simo.cinema.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PhotofilmServiceImp implements PhotoFilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository  ticketRepository;
    @Override
    public byte[] getPhotoFilm(long idFilm) {
        return new byte[0];
    }

    @Override
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }
    @Override
    public Film getFilm(Long idFilm){
        Film film = filmRepository.findById(idFilm).orElse(null);
        return film;
    }
    @Override
    public List<Ticket> payerTicket(TicketForm ticketForm){
        List<Ticket> ListTickets=new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket->{
           Ticket ticket = ticketRepository.findById(idTicket).get();
           ticket.setNomClient(ticketForm.getNomClient());
           ticket.setReserver(true);
           ticket.setCodePayement(ticketForm.getCodePayement());
           ticketRepository.save(ticket);
            ListTickets.add(ticket);
        });
        return ListTickets;
    }

}
