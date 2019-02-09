package com.example.demo.Repository;

import com.example.demo.Entity.Timereceive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface Timereceiverepository extends JpaRepository<Timereceive, Long> {


    Timereceive findByKeytime(String keytime);
}
