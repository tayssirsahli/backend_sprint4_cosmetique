package com.tayssir.cosmetique.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.entities.Image;
import com.tayssir.cosmetique.repos.CosmetiqueRepository;
import com.tayssir.cosmetique.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	CosmetiqueService cosmetiqueService;

	@Autowired
	CosmetiqueRepository cosmetiqueRepository;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes(), null);
		return imageRepository.save(image);
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		Image image = dbImage.orElseThrow(() -> new IOException("Image not found"));
		return new Image(image.getIdImage(), image.getName(), image.getType(), image.getImage(), image.getCosmetique());
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageCosm(MultipartFile file, Long idCosm) throws IOException {
		Cosmetique c = new Cosmetique();
		c.setIdCosmetique(idCosm);

		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setType(file.getContentType());
		image.setImage(file.getBytes());
		image.setCosmetique(c);

		return imageRepository.save(image);
	}

	@Override
	public List<Image> getImagesParCosm(Long cosmId) {
		Cosmetique c = cosmetiqueRepository.findById(cosmId).get();
		return c.getImages();
	}

}
