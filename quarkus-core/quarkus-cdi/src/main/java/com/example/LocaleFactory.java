package com.example;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import io.quarkus.arc.DefaultBean;

@ApplicationScoped
public class LocaleFactory {
	
	@Produces
	@Named("default")
	Locale defaultLocale=Locale.getDefault();

	@Produces
	@Named("ES")
	public Locale getESLocale() {
		Locale locale = new Locale("es", "ES");
		return locale;
	}
	
	@Produces
	@Named("US")
	public Locale getUSLocale() {
		Locale locale = Locale.US;
		return locale;
	}

}
