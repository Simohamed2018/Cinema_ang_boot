package com.simo.cinema.service;

import com.simo.cinema.model.*;
import com.simo.cinema.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;
@Service
@Transactional
public class CinemaInitServiceImp implements ICinemaInitService {
    @Autowired
    VilleRepository villeRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    CategorieFilmRepository categorieFilmRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    SeanceRepository seanceRepository;
    @Autowired
    ProjectionFilmRepository projectionFilmRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void initVilles() {
        Stream.of("Casablanca","Marrakech","Tanger","Agadir","Taza").forEach(nameVillev->{
            Ville ville =new Ville();
            ville.setNomVillee(nameVillev);
            ville.setDescription("ville  du Maroc .... ");
            ville.setNombreDeCinema(2 + (int)(new Random().nextInt(5)));
            villeRepository.save(ville);
        });

    }
//<p>Random rand = new Random(); int nombreAleatoire = rand.nextInt(max - min + 1) + min;
    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville->{
            Stream.of("MiGaRama"," Douliz","Malakiya","Rialto").forEach(nomCinema->{
                Cinema cinema =new Cinema();
                cinema.setNomCinema(nomCinema);
                cinema.setDescription("le nom du cinema est : "+ nomCinema+ "  a definir description ");
                cinema.setNombreDeSalle(3+(int)(Math.random()*2));
                cinema.setVille(ville);
                cinemaRepository.save(cinema);
            });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema->{
            for (int i = 0; i <cinema.getNombreDeSalle() ; i++) {
                Salle salle = new Salle();
                salle.setDescription("salle numeros :"+(i+1) );
                salle.setNombreDePlace(5+(int)(Math.random()*5));
                salle.setNomSalle("salle "+(i+1));
                salle.setCinema(cinema);
                salleRepository.save(salle);
            }
        });

    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle->{
            for (int i = 0; i <salle.getNombreDePlace(); i++) {
                Place place = new Place();
                place.setNumeroPlace((i+1));
                place.setNomPlace("Place  numeros :"+(i+1) );
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });
    }

    @Override
    public void initCategorieFilms() {
        Stream.of("Histoire","Drama","Actions","Fiction","Western").forEach(cat->{
            CategorieFilm categorie = new CategorieFilm();
            categorie.setNomCategorie(cat);
            categorie.setDescription("catgeroie descrition de "+cat);
            categorieFilmRepository.save(categorie);
        });

    }

    @Override
    public void initFilms() {
        double [] duree = new double[] {1,1.5,2,2.5,3,3.5,4};
        categorieFilmRepository.findAll().forEach(cat->{
            if (cat.getNomCategorie().contains("Drama"))
            {
                Stream.of("Drama 1","Drama 2","Drama 3").forEach(nomFilm->{
                    Film film  = new Film();
                    film.setNomFilm(nomFilm);
                    film.setDureeFilmEnHeure(duree[new Random().nextInt(duree.length)]);
                    film.setDescription("discritpin film a ajouter pour "+nomFilm);
                    film.setNomPhoto(nomFilm.replaceAll(" ","")+".jpg");
                    film.setCategorie(cat);
                    filmRepository.save(film);
                    film.setNomPhoto(film.getId()+".jpg");
                });

            }
            else if (cat.getNomCategorie().contains("Fiction"))
            {
                Stream.of("Fiction 1","Fiction 2","Fiction 3").forEach(nomFilm->{
                    Film film  = new Film();
                    film.setNomFilm(nomFilm);
                    film.setDureeFilmEnHeure(duree[new Random().nextInt(duree.length)]);
                    film.setDescription("discritpin film a ajouter pour "+nomFilm);
                    film.setNomPhoto(nomFilm.replaceAll(" ","")+".jpg");
                    film.setCategorie(cat);
                    filmRepository.save(film);
                    film.setNomPhoto(film.getId()+".jpg");
                });

            }
            else if (cat.getNomCategorie().contains("Actions")){
                Stream.of("Actions 1","Actions 2").forEach(nomFilm->{
                    Film film  = new Film();
                    film.setNomFilm(nomFilm);
                    film.setDureeFilmEnHeure(duree[new Random().nextInt(duree.length)]);
                    film.setDescription("discritpin film a ajouter pour "+nomFilm);
                    film.setNomPhoto(nomFilm.replaceAll(" ","")+".jpg");
                    film.setCategorie(cat);
                    filmRepository.save(film);
                    film.setNomPhoto(film.getId()+".jpg");
                });

            }
            else
            {
                Stream.of("film 1","film 2","film 3").forEach(nomFilm->{
                    Film film  = new Film();
                    film.setNomFilm(nomFilm);
                    film.setDureeFilmEnHeure(duree[new Random().nextInt(duree.length)]);
                    film.setDescription("discritpin film a ajouter pour "+nomFilm);
                    film.setNomPhoto(nomFilm.replaceAll(" ","")+".jpg");
                    film.setCategorie(cat);
                    filmRepository.save(film);
                    film.setNomPhoto(film.getId()+".jpg");
                });
            }

        });

    }

    @Override
    public void initSeances()  {
        DateFormat sdf =new SimpleDateFormat("HH:mm");
        Stream.of("11:00","13:00","15:00","17:00","21:00").forEach(sea->{
            Seance seance = new Seance();
            seance.setNomSeance("Seance-"+sea);
            try {
                seance.setHeureDebut(sdf.parse(sea));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            seanceRepository.save(seance);
        });
    }

    @Override
    public void initProjectionFilms() {
        double [] tableauPrix = new double []{30,50,40,100,120};
        villeRepository.findAll().forEach(ville->{
            ville.getCinemas().forEach(cinema->{
                cinema.getSalles().forEach(salle->{
                    filmRepository.findAll().forEach(film->{
                        seanceRepository.findAll().forEach(seance->{
                            ProjectionFilm projectionFilm =new ProjectionFilm();
                           // projectionFilm.setNomProjectionFilm("projection-"+salle.getNomSalle()+"-"+seance.getNomSeance()+"-"+film.getNomFilm());
                            projectionFilm.setDateProjection(new Date());
                            projectionFilm.setPrix(tableauPrix[new Random().nextInt(tableauPrix.length)]);
                            projectionFilm.setFilm(film);
                            projectionFilm.setSalle(salle);
                            projectionFilm.setSeance(seance);
                            projectionFilmRepository.save(projectionFilm);
                        });
                    });
                });
            });

        });

    }

    @Override
    public void initTickects() {
        projectionFilmRepository.findAll().forEach(projection->{
            projection.getSalle().getPlaces().forEach(place->{
                Ticket ticket =new Ticket();
               // ticket.setNomClient("nomClient"+ ticket.getId());
                ticket.setCodePayement(123456);
                ticket.setReserver(false);
                ticket.setPrix(projection.getPrix());
                ticket.setPlace(place);
                ticket.setProjectionFilm(projection);
                ticketRepository.save(ticket);

            });
            
        });

    }
}
