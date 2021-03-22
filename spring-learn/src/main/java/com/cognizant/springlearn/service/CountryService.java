package com.cognizant.springlearn.service;

import java.util.ArrayList;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");

	public Country getCountry(String code) throws CountryNotFoundException {
		Country country = countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
		if (country == null) {
			throw new CountryNotFoundException();
		}
		return country;
	}
}
