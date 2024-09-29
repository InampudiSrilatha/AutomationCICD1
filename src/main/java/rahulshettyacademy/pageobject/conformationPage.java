package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class conformationPage extends AbstractComponent{
	WebDriver driver;
	public conformationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement conformationmsg;

	public  String getConformationmessage()
	{
		checkOutPage cp = new checkOutPage(driver);
		return conformationmsg.getText();
	}
}
