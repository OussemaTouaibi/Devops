package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
public int ajouterContrat(Contrat contrat);
public void modifierContrat(Contrat contrat);
public void supprimerContrat(int id);
public List<Contrat> afficherAllContrat();
public Contrat afficherById(int id);
}
