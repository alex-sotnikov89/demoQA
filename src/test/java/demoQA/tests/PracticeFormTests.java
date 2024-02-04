package demoQA.tests;

import demoQA.TestBase;
import demoQA.models.M_PracticeForm;
import demoQA.pages.PracticeFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @ParameterizedTest(name = "Заполнение полей валидными значениями{0}")
    @Tags({@Tag("UI-Test"), @Tag("BLOCKER")})
    @MethodSource("demoQA.parameters.PracticeFormParam#fillPositiveArguments")
    void positiveInputFields(M_PracticeForm mPracticeForm) throws IOException {
        practiceFormPage.openPage();
        practiceFormPage.fillForm(mPracticeForm);
        $("#submit").scrollIntoView(true).click();
        practiceFormPage.verifyResults(mPracticeForm);
    }

    @ParameterizedTest(name = "Заполнение полей невалидными значениями{0}")
    @Tags({@Tag("UI-Test"), @Tag("BLOCKER")})
    @MethodSource("demoQA.parameters.PracticeFormParam#fillNegativeArguments")
    void negativeInputFields(M_PracticeForm mPracticeForm) {
        practiceFormPage.openPage();
        practiceFormPage.fillForm(mPracticeForm);

    }
}