package com.tayssir.cosmetique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayssir.cosmetique.entities.Classification;
import com.tayssir.cosmetique.repos.ClassificationRepository;

@Service
public class ClassificationServiceImp implements ClassificationService{

	 @Autowired
	 ClassificationRepository classificationRepository;
	 
	@Override
	public Classification saveClassification(Classification classification) {
		 return classificationRepository.save(classification);
	}

}
