package demoQA.pages;

import com.codeborne.selenide.SelenideElement;
import demoQA.models.M_PracticeForm;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {
    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");

    public void fillForm(M_PracticeForm practiceForm) {
        if (practiceForm.getFirstName() != null) {
            firstName.sendKeys(practiceForm.getFirstName());
        }
        if (practiceForm.getLastName() != null) {
            lastName.sendKeys(practiceForm.getLastName());
        }
    }
}
