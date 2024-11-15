package com.tayssir.cosmetique.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tayssir.cosmetique.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}

