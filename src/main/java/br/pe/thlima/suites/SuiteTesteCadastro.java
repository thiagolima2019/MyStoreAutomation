package br.pe.thlima.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.pe.thlima.test.TesteCadastroSucesso;
import br.pe.thlima.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastroSucesso.class,
	TesteRegrasCadastro.class
})

public class SuiteTesteCadastro {
}
