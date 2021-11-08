package tn.esprit.spring;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimesheetSpringBootCoreDataJpaMvcRest1Application {

	public static void main(String[] args) {
		BasicConfigurator.configure();

		SpringApplication.run(TimesheetSpringBootCoreDataJpaMvcRest1Application.class, args);
	}

}
