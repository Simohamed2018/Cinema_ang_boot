package com.simo.cinema.repo;

import com.simo.cinema.model.CategorieFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategorieFilmRepository extends JpaRepository<CategorieFilm, Long> {




}
