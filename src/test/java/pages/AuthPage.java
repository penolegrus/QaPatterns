package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private SelenideElement loginField = $x("//input[@id='login']");
    private SelenideElement passField = $x("//input[@id='password']");
    private SelenideElement okButton = $x("//button[@id='ok']");
    public MainPage auth(String login, String pass){
        loginField.sendKeys(login);
        passField.sendKeys(pass);
        okButton.click();
        return new MainPage();
    }
}
