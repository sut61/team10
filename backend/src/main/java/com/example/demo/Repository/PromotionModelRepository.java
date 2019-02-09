package com.example.demo.Repository;

import com.example.demo.Entity.PromotionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PromotionModelRepository extends JpaRepository<PromotionModel,Long> {
    PromotionModel findBypromotionnamemodel(String promotionnamemodel);
}
