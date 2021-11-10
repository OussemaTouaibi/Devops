package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	private static final Logger l = Logger.getLogger(TimesheetServiceTests.class);

	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	public int ajouterEntreprise(Entreprise entreprise) {
		l.info(" ajouter entreprise");
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		l.info(" ajout département");
		deptRepoistory.save(dep);
		return dep.getId();
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour
		// l'association
		// Rappel : la classe qui contient mappedBy represente le bout Slave
		// Rappel : Dans une relation oneToMany le mappedBy doit etre du cote
		// one.
		l.info("affecter Departement A Entreprise");

		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
		if (entrepriseManagedEntity != null && depManagedEntity != null) {
			depManagedEntity.setEntreprise(entrepriseManagedEntity);
			deptRepoistory.save(depManagedEntity);
		}

	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info("get All Departements Names By Entreprise");
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		List<String> depNames = new ArrayList<>();
		if (entrepriseManagedEntity != null) {
			for (Departement dep : entrepriseManagedEntity.getDepartements()) {
				depNames.add(dep.getName());
			}
		}

		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.info("delete Entreprise ById");
		Entreprise e = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		if (e != null) {
			entrepriseRepoistory.delete(e);
		}
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		l.info("delete Departement By Id");
		Departement dept = deptRepoistory.findById(depId).orElse(null);
		if (dept != null) {
			deptRepoistory.delete(dept);
		}
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("get Entreprise By Id");
		return entrepriseRepoistory.findById(entrepriseId).orElse(null);
	}

}
