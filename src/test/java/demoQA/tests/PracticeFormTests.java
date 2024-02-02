package demoQA.tests;

import demoQA.TestBase;
import demoQA.models.M_PracticeForm;
import demoQA.pages.PracticeFormPage;
import demoQA.parameters.PracticeFormParam;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @ParameterizedTest(name = "Заполнение полей {0}")
    @Tags({@Tag("UI-Test"), @Tag("BLOCKER")})
    @ArgumentsSource(PracticeFormParam.class)
    void positiveInputFields(M_PracticeForm mPracticeForm) throws IOException {
        practiceFormPage.openPage();
        practiceFormPage.fillForm(mPracticeForm);
        $("#submit").scrollIntoView(true).click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        practiceFormPage.verifyResults(mPracticeForm);
    }

    @Test
    void test() {

    }
}
