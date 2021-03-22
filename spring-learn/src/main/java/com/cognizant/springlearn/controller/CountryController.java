package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@Autowired
	private Country country;
	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		return (List<Country>) context.getBean("countryList");
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		return countryService.getCountry(code);
	}

	@PostMapping("/countries")
	public void addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");
		/*// Create validator factory

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		// Validation is done against the annotations defined in country bean

		Set<ConstraintViolation<Country>> violations = validator.validate(country);

		List<String> errors = new ArrayList<String>();

		// Accumulate all errors in an ArrayList of type String

		for (ConstraintViolation<Country> violation : violations) {

		errors.add(violation.getMessage());

		}

		// Throw exception so that the user of this web service receives appropriate error message

		if (violations.size() > 0) {

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

		}*/

		LOGGER.debug("Added {}", country);
		LOGGER.info("END");
}
}
