package com.cognizant.springlearn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource({ "classpath:country.xml" })
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountry();
		displayCountries();
	}

	public static void displayCountry() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = (Country) context.getBean("country", Country.class);
		LOGGER.info("HANDSON-001");
		LOGGER.debug("Country: " + country);
		LOGGER.info("HANDSON-002");
		LOGGER.debug("AnotherCountry: " + anotherCountry);
		LOGGER.info("END");
	}

	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list = context.getBean("countryList", ArrayList.class);
		LOGGER.info("HANDSON-003");
		LOGGER.debug("CountryList: " + list);
		LOGGER.debug("END");

	}
}
