package rahulshettyacademy.StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalouge;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.checkOutPage;
import rahulshettyacademy.pageobject.conformationPage;
import rahulshettyacademy.testComponents.BaseTest;

public class StepDefinationimpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalouge productCatalouge;
	public conformationPage conformtionpage;
	
	@Given("i landed on a Ecommerce page")
	
	public void i_landed_on_a_Ecommerce_page() throws IOException
	{
		landingPage=launchApplication();
	}

@Given("^Login with username (.+) and password (.+)$")	

public void Login_with_username_and_password(String username,String password)
{
	productCatalouge=landingPage.loginApplication(username,password);
}
	
@When("^Add product (.+)to the cart$")
public void Add_product_to_the_cart(String productname)
{
	 List<WebElement> products=productCatalouge.getProductList();
	 productCatalouge.addProductToCart(productname);
}
//checkout <ProductName>is displayed and submit the order
@When("^checkout (.+) is displayed and submit the order$")
public void checkout_product_is_displayed_and_submit_the_order(String productname)
{
	cartPage cartpage=productCatalouge.goToCartPage();
     boolean match=cartpage.verifyProuctDisplay(productname);
	Assert.assertTrue(match);
	checkOutPage checkoutpage =cartpage.goTocheckOut();
	checkoutpage.selectCountry("india");
	 conformtionpage=checkoutpage.submitOrder();

}
@Then("{string} message is displayed on comformation page")
public void message_is_displayed_on_comformation_page(String string)
{
	String confirmmsg=conformtionpage.getConformationmessage();
	Assert.assertTrue(confirmmsg.equalsIgnoreCase(string));
	driver.close();
}
@Then("^\"([^\"]*)\" message is displayed$")
public void Error_message_is_displayed(String strArg1)

{
	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
	driver.close();
}
}
