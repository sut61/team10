package com.example.demo.Repository;

import com.example.demo.Entity.Phototype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
public interface Phototyperepository extends JpaRepository<Phototype, Long> {
    Phototype findBynamephototype(String name);
}
