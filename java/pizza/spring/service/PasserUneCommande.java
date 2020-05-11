package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasserUneCommande {
		
	private WebDriver webdriver;
	@Before
	public void creatWebDriver() {
		webdriver = new ChromeDriver();
	}
	
	@After
	public void closeWebDriver() {
		webdriver.quit();
	}
	
	@Test
	public void OrderCommandeSuccessufully() throws Exception {
		PageDeRecapitulation pageDeRecapitulation = new PageDeRecapitulation(webdriver);
		PageDeCommande.openWith(webdriver)
							.SelectionnerUnePizzas("Margherita")
							.SelectionnerUnePizzas("Regina")
							.setNom("levy pinto")
							.setNumeroTel("0644042051")
							.clickOnCommander();
		assertTrue(pageDeRecapitulation.pizzaPresent() && pageDeRecapitulation.telephonePresent());
	}
	
	@Test
	public void OrderCommandeWithoutPhoneNumber() throws Exception{
		PageDeCommande pageDeCommande = new PageDeCommande(webdriver);
		PageDeCommande.openWith(webdriver)
					.openAPP()
					.SelectionnerUnePizzas("Regina")
					.setNom("Je ne donne pas mon numero")
					.setNumeroTel("")
					.clickOnCommander();
		assertTrue(pageDeCommande.telephonneInvalid());;
	}
	
	@Test
	public void OrderCommandeWithoutPizza() throws Exception{
		PageDeCommande pageDeCommande = new PageDeCommande(webdriver);
		PageDeCommande.openWith(webdriver)
					.openAPP()
					.doNotSelectPizza()
					.setNom("cette pizza n'existe pas")
					.setNumeroTel("0644042051")
					.clickOnCommander();
		assertTrue(pageDeCommande.pizzaInvalid());;
	}
	
}
