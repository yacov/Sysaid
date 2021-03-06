package com.sysaidit;

import com.sysaidit.pages.HomePage;
import com.sysaidit.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestNgTestBase {

  private HomePage homepage;
  private LoginPage loginPage;

  @BeforeClass
  public void testInit() {
    driver.get(baseUrl);
    homepage = PageFactory.initElements(driver, HomePage.class);
    loginPage = PageFactory.initElements(driver, LoginPage.class);
  }

  //@Test
  public void testHomePageHasAHeader() {
    Assert.assertFalse("".equals(homepage.header.getText()));
  }


  @Test(dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
  public void loginNegative (String useranme, String pass) {
    loginPage.fillLogin(useranme,pass);
    Assert.assertTrue(loginPage.checkErrorMessage(),"No error message appears");
    Assert.assertTrue(loginPage.isRememberChecked(),"RememberMe checkbox is not checked");
  }
}
