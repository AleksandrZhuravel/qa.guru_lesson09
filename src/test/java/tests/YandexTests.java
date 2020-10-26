package tests;



import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class YandexTests extends TestBase {
    @Test
    void yandexLocationPageShouldOpen() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.headless = true;

        open("https://yandex.ru");

        $(".geolink__reg").click();
        $(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(".input__control").setValue("Нячанг");
        $(".b-autocomplete-item").click();

        $(".geolink__reg").shouldHave(text("Нячанга"));
    }
}
