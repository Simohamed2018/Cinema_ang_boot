package com.simo.cinema.repo;

import com.simo.cinema.model.Cinema;
import com.simo.cinema.model.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm, Long> {




}
