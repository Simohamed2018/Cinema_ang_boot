package com.simo.cinema.repo;

import com.simo.cinema.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VilleRepository  extends JpaRepository<Ville, Long> {




}
