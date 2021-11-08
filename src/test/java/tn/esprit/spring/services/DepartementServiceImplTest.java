package tn.esprit.spring.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import java.text.ParseException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {

    @Autowired
    IEntrepriseService es;

    private static final Logger l = LogManager.getLogger(DepartementServiceImplTest.class);



    @Test
    public void ajouterDepartement() throws ParseException {

        Departement d = new Departement("dep");
        es.ajouterDepartement(d);
        assertNotNull(d.getName());

        l.info("department ");



    }

}