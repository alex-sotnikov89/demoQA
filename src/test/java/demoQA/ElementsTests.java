package demoQA;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ElementsTests {
    private final SelenideElement fullName = $("#userName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement permanentAddress = $("#permanentAddress");

    /**
     * <h3>Секция TextBox</h3>
     * <p>-Проверка порядка и наменования полей
     * <p>-Ввод текста
     */
    @Test
    void testTextBox() {
//        List<String> expFields = Arrays.asList("Full Name", "Email", "Current Address", "Permanent Address");
//        List<String> fieldsId = Arrays.asList("userName", "userEmail", "currentAddress", "permanentAddress");
//        List<String> fieldsValue = Arrays.asList("Aleks Smith", "Aleks@gmail.com", "Moscow city", "Red Square");

        open("https://demoqa.com/text-box");
        $(fullName).setValue("Aleks Smith");
        $(email).setValue("Aleks@gmail.com");
        $(currentAddress).setValue("Moscow city");
        $(permanentAddress).setValue("Red Square");
        $("#submit").scrollIntoView(true).click();
        $("p#name").scrollIntoView(true).shouldHave(text("Name:"));

//        $$(".form-label").shouldHave(texts(expFields)).shouldHave(size(4));
//        for (int i = 0; i < expFields.size(); i++) {
//            $(String.format("#%s", fieldsId.get(i))).setValue(fieldsValue.get(i));
//        }
    }
}

