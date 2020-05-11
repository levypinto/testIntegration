package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class PageDeRecapitulation {
	
	WebDriver webdriver;
	public PageDeRecapitulation(WebDriver webdriver) {
		this.webdriver = webdriver;

	}
	
	public boolean nomPresent() {
		System.out.println("nom de la recapitulation:"+ PageDeCommande.nom);
		return webdriver.getPageSource().contains(PageDeCommande.nom);
		
	}
	public boolean pizzaPresent() {
		return webdriver.getPageSource().contains(PageDeCommande.numero);
	}
	public boolean telephonePresent() {
		return webdriver.getPageSource().contains(PageDeCommande.numero);
	}
}
