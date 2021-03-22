package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.constraints.*;

public class Country {
	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
