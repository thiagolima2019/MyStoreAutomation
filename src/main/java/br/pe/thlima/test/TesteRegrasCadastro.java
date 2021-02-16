package br.pe.thlima.test;

import static br.pe.thlima.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import br.pe.thlima.core.BaseTeste;
import br.pe.thlima.core.DSL;
import br.pe.thlima.page.CadastroPage;

public class TesteRegrasCadastro extends BaseTeste {
	
	private CadastroPage page;
	private DSL dsl;
	
	@Before
	public void inicializa(){
		getDriver().get("http://automationpractice.com/index.php");
		page = new CadastroPage();	
		dsl = new DSL();
	}
		
	@Test
	public void deveValidarEmailVazioCadastro(){
		page.acessarloginCadastro();
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("create_account_error"), "Invalid email address."));
		String texto = dsl.obterTexto("create_account_error");
		Assert.assertEquals("Invalid email address.", texto);
	}
	
	@Test
	public void deveValidarRegraTelefone(){
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
		page.setNumeroResidencial("");
		page.setNumeroCelular("");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//li[contains(text(),'You must register at least one phone number.')]"), 
				"You must register at least one phone number."));
		String texto = page.obterRegraTelefone();
		Assert.assertEquals("You must register at least one phone number.", texto);
	}
	
	@Test
	public void deveValidarRegraPrimeiroNome(){
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("");
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
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//b[contains(text(),'firstname')]"), "firstname"));
		String texto = page.obterRegraPrimeiroNome();
		Assert.assertEquals("firstname", texto);
	}
	
	@Test
	public void deveValidarRegraUltimoNome(){
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubilove");
		page.setUltimoNomeCadastro("");
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
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//b[contains(text(),'lastname')]"), "lastname"));
		String texto = page.obterRegraUltimoNome();
		Assert.assertEquals("lastname", texto);
	}
	
	@Test
	public void deveValidarRegraZipCode(){
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubilove");
		page.setUltimoNomeCadastro("Silviano");
		page.setSenhaCadastro("12345");
		page.setDiaComboCadastro("24");
		page.setMesComboCadastro("2");
		page.setAnoComboCadastro("1995");
		page.setCompanhiaCadastro("Accenture");
		page.setEnderecoRuaCadastro("Rua aleatoria");
		page.setTipoMoradiaCadastro("Casa");
		page.setCidadeCadastro("Orlando");
		page.setEstadoComboCadastro("9");
		page.setNumeroPostalCadastro("");
		page.setInformacaoAdicionalCadastro("Proximo ao Camp Nou \n Arena Castelao \n Amazonia \n só isso");
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//li[contains(text(),\"The Zip/Postal code you've entered is invalid. It \")]"),
				"The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
		String texto = page.obterRegraZipCode();
		Assert.assertEquals("The Zip/Postal code you've entered is invalid. It must follow this format: 00000", texto);
	}
	
	@Test
	public void deveValidarRegraEndereco(){	
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubilove");
		page.setUltimoNomeCadastro("Silviano");
		page.setSenhaCadastro("12345");
		page.setDiaComboCadastro("24");
		page.setMesComboCadastro("2");
		page.setAnoComboCadastro("1995");
		page.setCompanhiaCadastro("Accenture");
		page.setEnderecoRuaCadastro("");
		page.setTipoMoradiaCadastro("Casa");
		page.setCidadeCadastro("Orlando");
		page.setEstadoComboCadastro("9");
		page.setNumeroPostalCadastro("98345");
		page.setInformacaoAdicionalCadastro("Proximo ao Camp Nou \n Arena Castelao \n Amazonia \n só isso");
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//b[contains(text(),'address1')]"), "address1"));
		String texto = page.obterRegraEndereco();
		Assert.assertEquals("address1", texto);
	}
	
	@Test
	public void deveValidarRegraCidade(){	
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubilove");
		page.setUltimoNomeCadastro("Silviano");
		page.setSenhaCadastro("12345");
		page.setDiaComboCadastro("24");
		page.setMesComboCadastro("2");
		page.setAnoComboCadastro("1995");
		page.setCompanhiaCadastro("Accenture");
		page.setEnderecoRuaCadastro("Rua esquisita");
		page.setTipoMoradiaCadastro("Casa");
		page.setCidadeCadastro("");
		page.setEstadoComboCadastro("9");
		page.setNumeroPostalCadastro("98345");
		page.setInformacaoAdicionalCadastro("Proximo ao Camp Nou \n Arena Castelao \n Amazonia \n só isso");
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//b[contains(text(),'city')]"), "city"));
		String texto = page.obterRegraCidade();
		Assert.assertEquals("city", texto);
	}
	
	@Test
	public void deveValidarRegraEstado(){
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubilove");
		page.setUltimoNomeCadastro("Silviano");
		page.setSenhaCadastro("12345");
		page.setDiaComboCadastro("24");
		page.setMesComboCadastro("2");
		page.setAnoComboCadastro("1995");
		page.setCompanhiaCadastro("Accenture");
		page.setEnderecoRuaCadastro("Rua esquisita");
		page.setTipoMoradiaCadastro("Casa");
		page.setCidadeCadastro("Orlando");
		page.setEstadoComboCadastro("");
		page.setNumeroPostalCadastro("98345");
		page.setInformacaoAdicionalCadastro("Proximo ao Camp Nou \n Arena Castelao \n Amazonia \n só isso");
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//li[contains(text(),'This country requires you to choose a State.')]"),
				"This country requires you to choose a State."));
		String texto = page.obterRegraEstado();
		Assert.assertEquals("This country requires you to choose a State.", texto);
	}
	
	@Test
	public void deveValidarRegraSenha(){	
		page.acessarloginCadastro();
		String fake = new Faker().internet().emailAddress();
		page.setEmailCadastro(fake);
		page.criarUmaConta();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		page.setSexoMasculino();
		page.setPrimeiroNomeCadastro("Jubilove");
		page.setUltimoNomeCadastro("Silviano");
		page.setSenhaCadastro("");
		page.setDiaComboCadastro("24");
		page.setMesComboCadastro("2");
		page.setAnoComboCadastro("1995");
		page.setCompanhiaCadastro("Accenture");
		page.setEnderecoRuaCadastro("Rua esquisita");
		page.setTipoMoradiaCadastro("Casa");
		page.setCidadeCadastro("Orlando");
		page.setEstadoComboCadastro("9");
		page.setNumeroPostalCadastro("98345");
		page.setInformacaoAdicionalCadastro("Proximo ao Camp Nou \n Arena Castelao \n Amazonia \n só isso");
		page.setNumeroResidencial("81 9884554545");
		page.setNumeroCelular("81 4365547654");
		page.setFuturaResidencia("Triplex na Disney");
		page.setFinalizarCadastro();
		wait.until(ExpectedConditions.textToBe(By.xpath("//b[contains(text(),'passwd')]"), "passwd"));
		String texto = page.obterRegraSenha();
		Assert.assertEquals("passwd", texto);
	}

}
