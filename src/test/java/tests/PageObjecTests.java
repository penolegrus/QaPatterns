package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.MainPage;

public class PageObjecTests {
    private AuthPage authPage;
    private MainPage mainPage;
    @BeforeEach
    public void initPages(){
        authPage = new AuthPage();
        mainPage = new MainPage();
    }
    @Test
    public void pagesTest(){
        authPage.auth("arbuz", "dinya");

        boolean isOk = mainPage.fillMobile("127812")
                .fillContactInfo("arbuz klubnika")
                .submitForm()
                .isErrorAppeared();
        Assertions.assertTrue(isOk);
    }
    @Test
    public void adminTest(){
        boolean isOk = authPage.auth("admin", "admin")
                .fillMobile("88005553535")
                .submitForm()
                .isErrorAppeared();
        Assertions.assertFalse(isOk);
    }
}
