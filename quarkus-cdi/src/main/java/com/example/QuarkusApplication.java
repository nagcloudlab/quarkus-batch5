package com.example;

import javax.inject.Inject;

import com.example.live.AnimalBean;
import com.example.live.HumanBean;
import com.example.service.TxrService;

public class QuarkusApplication implements io.quarkus.runtime.QuarkusApplication {

	@Inject
	TxrService txrService;

	@Inject
	HumanBean humanBean;

	@Inject
	AnimalBean animalBean;

	@Override
	public int run(String... args) throws Exception {

//		System.out.println("Quarkus Application bootstraped...");
//		txrService.txr(100.00, "1", "2");
		
		humanBean.live();
		animalBean.live();

		return 0;
	}

}
