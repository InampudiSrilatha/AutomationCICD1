package rahulshettyacademy.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalouge;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.checkOutPage;
import rahulshettyacademy.pageobject.conformationPage;
import rahulshettyacademy.testComponents.BaseTest;
import rahulshettyacademy.testComponents.Retry;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ErrorValidationTest extends BaseTest{

	@Test(groups= {"Error Handling"},retryAnalyzer=Retry.class)
	public void loginErrorValidaton() throws IOException
	{


landingPage.loginApplication("sri234@gmail.com", "Fjot&02");
Assert.assertEquals("Incorrect email  password.",landingPage.getErrorMessage());
}
	@Test
	public void productErrorValidation()
	{
		String Productname="ZARA COAT 3";
		ProductCatalouge productCatalouge=landingPage.loginApplication("sri123@gmail.com", "Fjot&023");
		List<WebElement> products=productCatalouge.getProductList();
		productCatalouge.addProductToCart(Productname);

		cartPage cartpage=productCatalouge.goToCartPage();
		boolean match=cartpage.verifyProuctDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}

}
