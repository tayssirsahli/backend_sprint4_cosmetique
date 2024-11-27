package com.tayssir.cosmetique.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.service.CosmetiqueService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CosmetiqueRESTController {

	@Autowired
	CosmetiqueService cosmetiqueService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<Cosmetique> getAllCosmetique() {
		return cosmetiqueService.getAllCosmetique();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Cosmetique getCosmetiqueById(@PathVariable("id") Long id) {
		return cosmetiqueService.getCosmetique(id);
	}

	@RequestMapping(path = "/addcos", method = RequestMethod.POST)
	public Cosmetique createCosmetique(@RequestBody Cosmetique cosmetique) {
		return cosmetiqueService.saveCosmetique(cosmetique);
	}

	@RequestMapping(path = "/updatecos", method = RequestMethod.PUT)
	public Cosmetique updateCosmetique(@RequestBody Cosmetique cosmetique) {
		return cosmetiqueService.updateCosmetique(cosmetique);
	}

	@RequestMapping(value = "/delcos/{id}", method = RequestMethod.DELETE)
	public void deleteCosmetique(@PathVariable("id") Long id) {
		cosmetiqueService.deleteCosmetiqueById(id);
	}

	@RequestMapping(value = "/cosmetiqueClas/{idClas}", method = RequestMethod.GET)
	public List<Cosmetique> getCosmetiqueByClasId(@PathVariable("idClas") Long idClas) {
		return cosmetiqueService.findByClassification_IdClas(idClas);
	}

	@RequestMapping(value = "/cosmetiqueByName/{nom}", method = RequestMethod.GET)
	public List<Cosmetique> findByNomCosmetiqueContains(@PathVariable("nom") String nom) {
		return cosmetiqueService.findByNomCosmetiqueContains(nom);
	}

	@GetMapping("/auth")
	Authentication getAuth(Authentication auth) {
		return auth;
	}

}
