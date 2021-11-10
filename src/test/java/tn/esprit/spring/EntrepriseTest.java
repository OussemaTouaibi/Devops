package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	
	private static final Logger l = Logger.getLogger(EntrepriseTest.class);
	@Autowired
	IEntrepriseService ie;

	@Test(timeout = 5000)
	public void ajouterEntrepriseTest() {
		l.info("Test ajout mession ");
		Entreprise e = new Entreprise("test", "testtest");
		int idEntrprise = ie.ajouterEntreprise(e)  ;
		assertThat(idEntrprise).isGreaterThan(0);
		
	}

	@Test
	public void ajouterDepartementTest() {
		l.info("ajouter Departement Test");
		Departement d = new Departement("test");
		Assert.assertNotEquals(0, ie.ajouterDepartement(d));
		
	}

	@Test
	public void affecterDepartementAEntrepriseTest() {
		l.info("affecter Departement A Entreprise Test");
		ie.affecterDepartementAEntreprise(6,10);
		
	}

	@Test
	public void getAllDepartementsNamesByEntreprise() {
		l.info("get All Departements Names By Entreprise");
		Assert.assertNotEquals(0 , ie.getAllDepartementsNamesByEntreprise(10).size());
	}

	@Test
	public void deleteEntrepriseById() {
		l.info("delete Entreprise By Id");
		ie.deleteEntrepriseById(2);
	}

	@Test
	public void deleteDepartementById() {
		l.info("delete Departement By Id");
		ie.deleteDepartementById(3);
	}

	

}