package demoQA.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import demoQA.TestBase;
import demoQA.models.M_PracticeForm;
import demoQA.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
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
        $("#submit").scrollIntoView(true).click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        practiceFormPage.verifyResults("Student Name", "Masha Night");
        practiceFormPage.verifyResults("Student Email", "night_masha@r.com");
        practiceFormPage.verifyResults("Gender", "Female");
    }

}
