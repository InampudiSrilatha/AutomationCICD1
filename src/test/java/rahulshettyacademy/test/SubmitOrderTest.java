package rahulshettyacademy.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalouge;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.checkOutPage;
import rahulshettyacademy.pageobject.conformationPage;
import rahulshettyacademy.pageobject.orderPage;
import rahulshettyacademy.testComponents.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTest extends BaseTest{
	String Productname="ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException
	{


ProductCatalouge productCatalouge=landingPage.loginApplication(input.get("email"),input.get("password"));
 List<WebElement> products=productCatalouge.getProductList();
productCatalouge.addProductToCart(input.get("product"));
cartPage cartpage=productCatalouge.goToCartPage();

boolean match=cartpage.verifyProuctDisplay(input.get("product"));
Assert.assertTrue(match);
checkOutPage checkoutpage =cartpage.goTocheckOut();
checkoutpage.selectCountry("india");
conformationPage conformtionpage=checkoutpage.submitOrder();
String confirmmsg=conformtionpage.getConformationmessage();
Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
}
	
 @Test(dependsOnMethods= {"submitOrder"})
 public void orderHistoryTest()
 {
	 ProductCatalouge productCatalouge=landingPage.loginApplication("sri234@gmail.com", "Fjot&023");
	 orderPage orderpage=productCatalouge.goToorderPage();
	 Assert.assertFalse(orderpage.verifyorderDisplay(Productname));
	
 }
 


 @DataProvider
 public Object[][] getData() throws IOException
 {
List<HashMap<String,String>> data= getJsonDataMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
 }
}
