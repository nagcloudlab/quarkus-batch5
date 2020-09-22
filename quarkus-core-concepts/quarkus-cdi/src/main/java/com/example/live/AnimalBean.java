package com.example.live;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

//@ApplicationScoped
@Singleton
public class AnimalBean {

	@Inject
	FoodBean foodBean;

	private static Logger logger = Logger.getLogger("txr-service");

	public AnimalBean() {
		logger.info("Animalbean instatiated.");
	}
	
	public void live() {
		System.out.println(foodBean);
	}

}
