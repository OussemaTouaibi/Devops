package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
@Service
public class ContratService implements IContratService {
    @Autowired
    ContratRepository c;
	@Override
	public int ajouterContrat(Contrat contrat) {
	    c.save(contrat);
		return 0;
	}

	@Override
	public void modifierContrat(Contrat contrat) {
		c.save(contrat);
		
	}

	@Override
	public void supprimerContrat(int id) {
		List<Contrat> cont=(List<Contrat>) c.findAll();
		if(c.findById(id).isPresent()){
		Contrat contratManagedEntity = cont.get(id);
		c.delete(contratManagedEntity);}
		
	}

	@Override
	public List<Contrat> afficherAllContrat() {
		return (List<Contrat>) c.findAll();
	}

	@Override
	public Contrat afficherById(int id) {
		List<Contrat> cont=(List<Contrat>) c.findAll();
		if(c.findById(id).isPresent()){
		
		return cont.get(id);}
		return null;
	}

}
