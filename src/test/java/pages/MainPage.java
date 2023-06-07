package pages;

import com.codeborne.selenide.SelenideElement;
import factories.DriverTestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement contactField = $x("//input[@class='field-contanc]");
    private SelenideElement mobildField = $x("//input[@id='mobile']");
    private SelenideElement submitBtn = $x("//button[@id='submit']");

    public MainPage fillContactInfo(String value) {
        contactField.sendKeys(value);
        return this;
    }

    public MainPage fillMobile(String mobilePhone) {
        mobildField.sendKeys(mobilePhone);
        return this;
    }

    public MainPage submitForm() {
        submitBtn.click();
        return this;
    }

    public boolean isErrorAppeared(){
        return $x("//input[@id='error']").exists();
    }
}
