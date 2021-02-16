package br.pe.thlima.core;

import static br.pe.thlima.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTeste {

	@After
	public void finaliza(){
	killDriver();
	}
	
}
