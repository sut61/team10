package com.example.demo.Repository;


import com.example.demo.Entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface Equipmentrepository extends JpaRepository<Equipment, Long>{
    Equipment findByKey(String key);
}
