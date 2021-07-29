import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    SelenideElement loginField = $("#session_email");
    SelenideElement passwordField = $("#session_password");
    SelenideElement signInButton = $(By.name("commit"));


    void login() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        loginField.sendKeys(props.getProperty("user.username"));
        passwordField.sendKeys(props.getProperty("user.password"));
        signInButton.click();
    }

    public void openLoginPage(){
        open("http://a.testaddressbook.com/sign_in");
    }


}
