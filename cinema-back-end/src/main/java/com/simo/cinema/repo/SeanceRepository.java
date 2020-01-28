package com.simo.cinema.repo;

import com.simo.cinema.model.Cinema;
import com.simo.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance, Long> {




}
