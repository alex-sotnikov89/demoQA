package demoQA.tests;

import demoQA.TestBase;
import demoQA.models.M_PracticeForm;
import demoQA.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void name() {
        open("/automation-practice-form");
        practiceFormPage.fillForm(M_PracticeForm.builder()
                .firstName("lala").build());
        sleep(5000);
    }

}
