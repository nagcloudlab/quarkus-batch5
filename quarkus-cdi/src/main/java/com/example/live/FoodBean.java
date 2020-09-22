package com.example.live;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

//@ApplicationScoped
//@Singleton
@Dependent
public class FoodBean {
	
	private static Logger logger = Logger.getLogger("txr-service");

	
	public FoodBean() {
		logger.info("Foodbean instantiated..");
	}

}
