package demoQA.tests;

import demoQA.TestBase;
import demoQA.models.M_PracticeForm;
import demoQA.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void name() {
        practiceFormPage.openPage();
        practiceFormPage.fillForm(
                M_PracticeForm
                        .builder()
                        .firstName("Masha")
                        .lastName("Night")
                        .email("night_masha@r.com")
                        .gender("Female")
                        .mobile("8901123456")
                        .dateOfBirth(LocalDate.of(2020, 9, 2))
                        .subjects("Maths")
                        .hobbies(new String[]{"Reading", "Music"})
                        .currentAddress("Red square st., 11, 100")
                        .state("Haryana")
                        .city("Karnal")
                        .build());
        $("#submit").click();
    }

}
