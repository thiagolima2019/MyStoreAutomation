package br.pe.thlima.page;

import org.openqa.selenium.By;

import br.pe.thlima.core.BasePage;

public class CadastroPage extends BasePage {
	
	public void acessarloginCadastro(){
		dsl.clicarBotao(By.xpath("//a[@class='login']"));
		
	}
	
	public void criarUmaConta(){
		dsl.clicarBotao("SubmitCreate");
	}

		
	public void setEmailCadastro(String email){
		dsl.escrever("email_create", email);
	}
	
	public void setCompanhiaCadastro(String companhia){
		dsl.escrever("company", companhia );
	}
	
	public void setEnderecoRuaCadastro(String rua){
		dsl.escrever("address1", rua);
	}
	
	public void setTipoMoradiaCadastro(String moradia){
		dsl.escrever("address2", moradia);
	}
	
	public void setCidadeCadastro(String cidade){
		dsl.escrever("city", cidade);
	}
	
	public void setPrimeiroNomeCadastro(String nome){
		dsl.escrever("customer_firstname", nome);
	}
	
	public void setUltimoNomeCadastro(String nome){
		dsl.escrever("customer_lastname", nome);
	}
	
	public void setNumeroPostalCadastro(String texto){
		dsl.escrever("postcode", texto);
	}
	
	public void setSenhaCadastro(String senha){
		dsl.escrever("passwd", senha);
	}
	public void setSexoMasculino(){
		dsl.clicarRadio("id_gender1");
	}
	
	public void setDiaComboCadastro(String texto){
		dsl.selecionarCombo("days", texto);
	}
	
	public void setMesComboCadastro(String texto){
		dsl.selecionarCombo("months", texto);
	}
	
	public void setAnoComboCadastro(String texto){
		dsl.selecionarCombo("years", texto);
	}
	
	public void setEstadoComboCadastro(String texto){
		dsl.selecionarCombo("id_state", texto);
	}
	
	public void setInformacaoAdicionalCadastro(String texto){
		dsl.escrever("other", texto);
		
	}
	
	public void setNumeroResidencial(String numero_fix){
		dsl.escrever("phone", numero_fix);
	}
	
	public void setNumeroCelular(String numero_movel){
		dsl.escrever("phone_mobile", numero_movel);
	}
	
	public void setFuturaResidencia(String texto){
		dsl.escrever("alias", texto);
	}
	
	public void setFinalizarCadastro(){
		dsl.clicarBotao("submitAccount");
	}
	
	// ---------- Regras -----------//
	
	public String obterRegrasCadastro(){
		return dsl.obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public String obterRegraTelefone(){
		return dsl.obterTexto(By.xpath("//li[contains(text(),'You must register at least one phone number.')]"));
	}
	
	public String obterRegraPrimeiroNome(){
		return dsl.obterTexto(By.xpath("//b[contains(text(),'firstname')]"));
	}
	public String obterRegraUltimoNome(){
		return dsl.obterTexto(By.xpath("//b[contains(text(),'lastname')]"));
	}
	public String obterRegraZipCode(){
		return dsl.obterTexto(By.xpath("//li[contains(text(),\"The Zip/Postal code you've entered is invalid. It \")]"));
	}
	
	public String obterRegraEndereco(){
		return dsl.obterTexto(By.xpath("//b[contains(text(),'address1')]"));
	}
	public String obterRegraEstado(){
		return dsl.obterTexto(By.xpath("//li[contains(text(),'This country requires you to choose a State.')]"));
	}
	public String obterRegraCidade(){
		return dsl.obterTexto(By.xpath("//b[contains(text(),'city')]"));
	}
	public String obterRegraSenha(){
		return dsl.obterTexto(By.xpath("//b[contains(text(),'passwd')]"));
	}
}
