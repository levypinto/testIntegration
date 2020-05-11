package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class PageDeCommande {
	
	private WebDriver webdriver;
	public static String nom = "";
	public static String numero ="";
	public static String pizza = "";
	
	public PageDeCommande(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	public PageDeCommande openAPP() {
		webdriver.navigate().to("http://localhost:8080/pizza-spring/commande");
		assertTrue(webdriver.getTitle().startsWith("Pizza Spring"));
		return this;
	}
	
	public static PageDeCommande openWith(WebDriver webDriver) {
		PageDeCommande pageDeCommande = new PageDeCommande(webDriver);
		pageDeCommande.openAPP();
		return pageDeCommande;
	}

	public PageDeCommande setNom (String... words) {
		WebElement input = webdriver.findElement(By.id("nom"));
		input.sendKeys(String.join(" ", words));
		nom = String.join(" ", words);
		System.out.println(nom);
		return this;
	}
	

	public PageDeCommande setNumeroTel (String phone_number) {
		WebElement input = webdriver.findElement(By.id("telephone"));
		input.sendKeys(phone_number);
		numero = phone_number;
		return this;
	}
	
	public PageDeCommande SelectionnerUnePizzas(String pizza) throws Exception {
		WebElement select = webdriver.findElement(By.id("pizzaId"));
        Select selectPizzas = new Select(select);
        selectPizzas.deselectByVisibleText(pizza);   
		return this;
	}
	
	public void clickOnCommander() {
		WebElement submit_button = webdriver.findElement(By.cssSelector("button"));
		submit_button.click();
	}
	public boolean telephonneInvalid() throws Exception {
		WebElement label = webdriver.findElement(By.id("telephone.errors"));
		return label.isDisplayed();
	}
	public boolean pizzaInvalid() throws Exception {
		WebElement label = webdriver.findElement(By.id("pizzaId.errors"));
		return label.isDisplayed();
	}
	
	public PageDeCommande doNotSelectPizza() {
		WebElement select = webdriver.findElement(By.id("pizzaId"));
        Select selectPizzas = new Select(select);
        selectPizzas.deselectAll();
        return this;
	}
	
}
