package br.pe.thlima.core;

import static br.pe.thlima.core.DriverFactory.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	// --------------- Botão ------------- //
	
	public void clicarBotao(By by){
		getDriver().findElement(by).click();;
	}
	
	public void clicarBotao(String id){
		clicarBotao(By.id(id));
	}
	
	
	// --------------- Textos ----------- //
	
	public String obterTexto(By by){
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id){
		return obterTexto(By.id(id));
	}
	
	
	
	// ------------- Alerts -------------//
	
	public String alertObterTexto(){
		 Alert alert = getDriver().switchTo().alert();
		 return alert.getText();
	}
	
	// ----- Text Field e Text Area -----//
	
	public void escrever(By by, String valor){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(valor);
	}
	
	public void escrever(String id, String valor){
		escrever(By.id(id), (valor));
	}
	
//------//
	
	
	// ----- Radio Button e CheckBox ---//
	
	public void clicarRadio(String id){
		getDriver().findElement(By.id(id)).click();
	}
	
	// ----------- Combo ------------- //
	
	public void selecionarCombo(String id, String value){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByValue(value);
	}
		
}


