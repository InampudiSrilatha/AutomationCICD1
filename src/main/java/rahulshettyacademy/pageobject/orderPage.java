package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.abstractComponents.AbstractComponent;

public class orderPage extends AbstractComponent{
	WebDriver driver;
	public orderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css =".tr td:nth-child(2)")
	List<WebElement> productNames;
	
	@FindBy(css =".totalRow button")
	WebElement checkout;
	
	public boolean verifyorderDisplay(String Productname)
	{
		boolean match=productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(Productname));
		return match;
		
	}



}