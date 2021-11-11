package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
@RestController
public class RestControlContrat {
@Autowired
IContratService c;
@PostMapping("/ajouterContrat")
@ResponseBody
public Contrat ajouterContrat(@RequestBody Contrat contrat) {
	c.ajouterContrat(contrat);
	return contrat;
}


@PutMapping("/modifyContrat")
@ResponseBody
public void ModifyContrat(@RequestBody Contrat contrat) {
	c.modifierContrat(contrat);
}

@DeleteMapping("/deleteontrat/{id}")
@ResponseBody
public String deleteContrat(@PathVariable ("id")int  id) {
	c.supprimerContrat(id);
	return "succ";
}
@GetMapping("/afficheAllContrat")
@ResponseBody
public List<Contrat> afficheallcontrat() {
	return c.afficherAllContrat();
	
}
@GetMapping("/afficheContrat/{id}")
@ResponseBody
public Contrat affichecontrat(@PathVariable ("id")int  id) {
	return c.afficherById(id);
	
}
}
