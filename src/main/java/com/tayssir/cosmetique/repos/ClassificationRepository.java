package com.tayssir.cosmetique.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tayssir.cosmetique.entities.Classification;

@RepositoryRestResource(path = "rest")
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

	

}
