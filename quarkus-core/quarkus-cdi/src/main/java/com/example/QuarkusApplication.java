package com.example;

import java.util.Locale;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.live.AnimalBean;
import com.example.live.HumanBean;
import com.example.service.TxrService;

public class QuarkusApplication implements io.quarkus.runtime.QuarkusApplication {

	@Inject
	TxrService txrService;

//	@Inject
//	HumanBean humanBean;
//
//	@Inject
//	AnimalBean animalBean;

//	@Inject
//	@Named("ES")
//	Locale spanishLocale;
//
//	@Inject
//	@Named("US")
//	Locale usLocale;
//	
//	@Inject
//	@Named("default")
//	Locale defaultLocale;

	@Override
	public int run(String... args) throws Exception {

//		System.out.println("Quarkus Application bootstraped...");
		txrService.txr(100.00, "1", "2");

//		humanBean.live();
//		animalBean.live();
//
//		System.out.println(spanishLocale.getLanguage() + " - " + spanishLocale.getCountry());
//		
//		System.out.println(usLocale.getLanguage() + " - " + usLocale.getCountry());
//		
//		System.out.println(defaultLocale.getLanguage() + " - " + defaultLocale.getCountry());

		return 0;
	}

}
