package com.tayssir.cosmetique.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    private String name;
    private String type;

    @Column(name = "IMAGE", length = 4048576)
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn (name="COSMETIQUE_ID")
    @JsonIgnore
    private Cosmetique cosmetique;

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Cosmetique getCosmetique() {
		return cosmetique;
	}

	public void setCosmetique(Cosmetique cosmetique) {
		this.cosmetique = cosmetique;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String name, String type, byte[] image, Cosmetique cosmetique) {
		super();
		this.name = name;
		this.type = type;
		this.image = image;
		this.cosmetique = cosmetique;
	}

	public Image(Long idImage, String name, String type, byte[] image, Cosmetique cosmetique) {
		super();
		this.idImage = idImage;
		this.name = name;
		this.type = type;
		this.image = image;
		this.cosmetique = cosmetique;
	}
	

    
}
