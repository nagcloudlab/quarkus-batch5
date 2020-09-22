package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class ApplicationLifecycle {

	public void init(@Observes StartupEvent event) {
		System.out.println("ApplicationLifecycle : init()");
		//....
	}

	public void destroy(@Observes ShutdownEvent event) {
		System.out.println("ApplicationLifecycle : destroy()");
		//...
	}

}
