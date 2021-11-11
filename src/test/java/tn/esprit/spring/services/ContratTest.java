package tn.esprit.spring.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ContratTest.class)
public class ContratTest {
	
	ContratService c;
private static final Logger l =  LogManager.getLogger(ContratTest.class);
	
	@Test(expected=NullPointerException.class)
	public void ajoutercontratTest() {
		Contrat e = new Contrat(50,4);
	    
		int idcontrat = c.ajouterContrat(e);
		assertThat(idcontrat).isPositive();
		l.info("contrat ajouté");
	}

	@Test(expected=NullPointerException.class)

	public void deleteContratByIdTest() {
		Contrat d = new Contrat(5,2);

		Assert.assertNotNull(d.getReference());
		c.supprimerContrat(d.getReference());
		l.info("supprimé");
	}
	
	@Test(expected=NullPointerException.class)

	public void getContratByIdTest() {
		Contrat d = new Contrat(4,44);
		
		Assert.assertNotNull(d.getReference());
	c.afficherById(d.getReference());
		l.info("affiché");
		
	}


	

}