package demoQA;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ElementsTests {
    private final SelenideElement
            fullName = $("#userName"),
            email = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress");

    /**
     * <h3>Секция TextBox</h3>
     * <p>-Проверка порядка и наменования полей
     * <p>-Ввод текста
     */
    @Test
    void testTextBox() {
        System.setProperty("webdriver.chrome.driver", "D:\\dev\\drivers\\yandexdriver.exe");
        Configuration.browserBinary="C:\\Users\\alex_\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        Configuration.reopenBrowserOnFail = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 300000L;
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browser="firefox";
        List<String> expFields = Arrays.asList("Full Name", "Email", "Current Address", "Permanent Address");
//        List<String> fieldsId = Arrays.asList("userName", "userEmail", "currentAddress", "permanentAddress");
//        List<String> fieldsValue = Arrays.asList("Aleks Smith", "Aleks@gmail.com", "Moscow city", "Red Square");

        open("https://demoqa.com/text-box");
        $$(".form-label").shouldHave(texts(expFields)).shouldHave(size(4));
        $(fullName).setValue("Aleks Smith");
        $(email).setValue("Aleks@gmail.com");
        $(currentAddress).setValue("Moscow city");
        $(permanentAddress).setValue("Red Square");
        $("#submit").scrollIntoView(true).click();
        $("p#name").scrollIntoView(true).shouldHave(text("Name:"));

//        for (int i = 0; i < expFields.size(); i++) {
//            $(String.format("#%s", fieldsId.get(i))).setValue(fieldsValue.get(i));
//        }
    }
}

