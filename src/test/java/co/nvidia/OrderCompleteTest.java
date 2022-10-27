package co.nvidia;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Hooks;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
	}

	@Test
	public void endToEndTest() throws IOException {

		Homepage home = new Homepage();
		home.getTestStoreLink().click();

		ShopHomepage shopHome = new ShopHomepage();
		shopHome.getProdOne().click();

		ShopProductPage shopProd = new ShopProductPage();
		Select shirtSize = new Select(shopProd.getSizeOption());
		shirtSize.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();

		cart.getProceedCheckoutBtn().click();

		OrderFormPersInfo pInfo = new OrderFormPersInfo();
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("Eitan");
		pInfo.getLastnameField().sendKeys("Smith");
		pInfo.getEmailField().sendKeys("pewdiepie122222221@gmail.com");
		pInfo.getTermsConditionsCheckbox().click();
		pInfo.getContinueBtn().click();

		OrderFormDelivery orderDelivery = new OrderFormDelivery();
		orderDelivery.getAddressField().sendKeys("Richardson 28");
		orderDelivery.getCityField().sendKeys("New York");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("New York");
		orderDelivery.getPostcodeField().sendKeys("55555");
		orderDelivery.getContinueBtn().click();

		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("Please be quick :)");
		shipMethod.getContinueBtn().click();

		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();

	}
}
