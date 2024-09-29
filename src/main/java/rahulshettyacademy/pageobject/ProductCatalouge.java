package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent{
	WebDriver driver;
	public ProductCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//WebElement UserEmail=driver.findElement(By.id("userEmail"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	 By products1 =By.cssSelector(".mb-3");
	 By addToCart=By.cssSelector(".card-body button:last-of-type");
	 By toastMessage=By.cssSelector("#toast-container");
	 
	 @FindBy(css=".ng-animating")
	 WebElement spinner;
	 
	public List<WebElement> getProductList()
	{
		waitElementToAppear(products1);
		return products;
	}
	
	public WebElement getProductByName(String Productname)
	{
		WebElement prod =getProductList().stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals(Productname)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String Productname)
	{
		WebElement prod=getProductByName(Productname);
		prod.findElement(addToCart).click();
		waitElementToAppear(toastMessage);
		waitElementToDisppear(spinner);
	}
}
