package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.abstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css =".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css =".totalRow button")
	WebElement checkout;
	
	public boolean verifyProuctDisplay(String Productname)
	{
		boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(Productname));
		return match;
		
	}
public checkOutPage goTocheckOut()
{
	checkout.click();
	checkOutPage checkout = new checkOutPage(driver);
	return checkout;
}


}