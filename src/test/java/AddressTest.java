import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import java.io.File;
import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressTest {

    @BeforeEach
    public void setUp() {
//        Configuration.headless = true;
        Configuration.startMaximized = true;

    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @Order(1)
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login();
        loginPage.welcomeMessage.shouldBe(visible);
        Assertions.assertEquals("Welcome to Address Book", loginPage.welcomeMessage.getText());

    }

    @Test
    @Order(2)
    public void createNewAddressTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        AddressPage address = new AddressPage();
        loginPage.openLoginPage();
        loginPage.login();
        loginPage.addressesButton.click();
        address.createNewAddressButton.click();
        address.firstNameField.sendKeys("firstName");
        address.lastNameField.sendKeys("lastname");
        address.address1Field.sendKeys("address 1");
        address.address2Field.sendKeys("address 2");
        address.cityField.sendKeys("city");
        address.stateSelect.click();
        address.floridaOption.click();
        address.zipCodeField.sendKeys("09822");
        address.countryUSRadioButton.click();
        address.birthdayCalendar.sendKeys("01032002");
        address.ageField.sendKeys("27");
        address.websiteField.sendKeys("http://somesite.com");
        address.uploadImage.uploadFile(new File("src/main/resources/somefile.jpg"));
        address.phoneField.sendKeys("23232323");
        address.interestsClimbCheckBox.click();
        address.noteFiled.sendKeys("Some notes");
        address.commitButton.click();
        Selenide.sleep(2000);

        Assertions.assertEquals("Address was successfully created.", address.notice.getText());

    }
    @Test
    @Order(3)
    public void deleteFirstAddressTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        AddressPage address = new AddressPage();
        loginPage.openLoginPage();
        loginPage.login();
        loginPage.addressesButton.click();
        address.tableBody.shouldBe(visible);
        ElementsCollection addressCollection = address.tableBody.$$("tr");
        int addressSizeBefore = addressCollection.size();
        addressCollection.first().$(By.xpath("td/a[text()='Destroy']")).click();
        switchTo().alert().accept();
        int addressSizeAfter = addressCollection.size();
        Assertions.assertEquals(addressSizeBefore,addressSizeAfter+1);



    }

}