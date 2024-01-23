package demoQA.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import demoQA.TestBase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ElementsTests extends TestBase {
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
        List<String> expFields = Arrays.asList("Full Name", "Email", "Current Address", "Permanent Address");
//        List<String> fieldsId = Arrays.asList("userName", "userEmail", "currentAddress", "permanentAddress");
        List<String> fieldsValue = Arrays.asList("Aleks Smith", "Aleks@gmail.com", "Moscow city", "Red Square");

        open("/text-box");
        $$(".form-label").shouldHave(texts(expFields)).shouldHave(size(4));
        $(fullName).setValue(fieldsValue.get(0));
        $(email).setValue(fieldsValue.get(1));
        $(currentAddress).setValue(fieldsValue.get(2));
        $(permanentAddress).setValue(fieldsValue.get(3));
        $("#submit").scrollIntoView(true).click();
        $("p#name").scrollIntoView(true).shouldHave(text("Name:" + fieldsValue.get(0)));
        $("p#email").shouldHave(text("Email:" + fieldsValue.get(1)));
        $("p#currentAddress").shouldHave(text("Current Address :" + fieldsValue.get(2)));
        $("p#permanentAddress").shouldHave(text("Permananet Address :" + fieldsValue.get(3)));

//        for (int i = 0; i < expFields.size(); i++) {
//            $(String.format("#%s", fieldsId.get(i))).setValue(fieldsValue.get(i));
//        }
    }

    @Test
    void testTextBox_v2() {
        Configuration.reopenBrowserOnFail = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        System.setProperty("webdriver.chrome.driver", "D:\\dev\\drivers\\yandexdriver.exe");
        Configuration.browserBinary = "C:\\Users\\alex_\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
    }

}

