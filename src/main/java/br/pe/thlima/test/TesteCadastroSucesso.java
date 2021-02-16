package br.pe.thlima.test;

import static br.pe.thlima.core.DriverFactory.getDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import br.pe.thlima.core.BaseTeste;
import br.pe.thlima.page.CadastroPage;

public class TesteCadastroSucesso extends BaseTeste { 

	private CadastroPage page;
	
	@Before
	public void inicializa(){
		getDriver().get("http://automationpractice.com/index.php");
		page = new CadastroPage();
	}
	
	@Test
	public void efetuarCadastroSucesso() throws InterruptedException{
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubileu");
		page.setUltimoNomeCadastro("Silva");
		page.setSenhaCadastro("12345");
		page.setDiaComboCadastro("24");
		page.setMesComboCadastro("2");
		page.setAnoComboCadastro("1995");
		page.setCompanhiaCadastro("Accenture");
		page.setEnderecoRuaCadastro("Rua aleatoria");
		page.setTipoMoradiaCadastro("Casa");
		page.setCidadeCadastro("Orlando");
		page.setEstadoComboCadastro("9");
		page.setNumeroPostalCadastro("32819");
		page.setInformacaoAdicionalCadastro("Proximo ao Camp Nou \n Arena Castelao \n Amazonia \n só isso");
		page.setNumeroResidencial("81 32318790");
		page.setNumeroCelular("81 999998877");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
	
	}

	
	
}
