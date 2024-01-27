package demoQA.tests;

import demoQA.TestBase;
import demoQA.models.M_PracticeForm;
import demoQA.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void name() throws IOException {
        M_PracticeForm mPracticeForm = M_PracticeForm
                .builder()
                .firstName("Masha")
                .lastName("Night")
//                .email("night_masha@r.com")
                .gender("Female")
                .mobile("8901123456")
                .dateOfBirth(LocalDate.of(2020, 9, 2))
                .subjects(new String[]{"Maths","Physics"})
                .hobbies(new String[]{"Reading", "Music"})
                .currentAddress("Red square st., 11, 100")
                .state("Haryana").city("Karnal")
                .build();
        practiceFormPage.openPage();
        practiceFormPage.fillForm(mPracticeForm);
        $("#submit").scrollIntoView(true).click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        practiceFormPage.verifyResults("Student Name", "Masha Night");
        practiceFormPage.verifyResults("Gender", "Female");
        practiceFormPage.verifyResults(mPracticeForm);
    }
}
