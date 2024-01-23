package demoQA.pages;

import com.codeborne.selenide.SelenideElement;
import demoQA.models.M_PracticeForm;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement email = $("#userEmail");
    SelenideElement gender = $("#genterWrapper");
    SelenideElement mobile = $("#userNumber");
    SelenideElement dateOfBirth = $("#dateOfBirthInput");
    SelenideElement datePicker = $("[data-placement*='start']");
    SelenideElement subjects = $("#subjectsInput");
    SelenideElement hobbies = $("#hobbiesWrapper");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement state = $("#state");
    SelenideElement city = $("#city");

    public void openPage() {
        open("/automation-practice-form");
    }

    public void fillForm(M_PracticeForm practiceForm) {
        if (practiceForm.getFirstName() != null) {
            firstName.sendKeys(practiceForm.getFirstName());
        }
        if (practiceForm.getLastName() != null) {
            lastName.sendKeys(practiceForm.getLastName());
        }
        if (practiceForm.getEmail() != null) {
            email.sendKeys(practiceForm.getEmail());
        }
        if (practiceForm.getGender() != null) {
            gender.$(byText(practiceForm.getGender())).click();
        }
        if (practiceForm.getMobile() != null) {
            mobile.sendKeys(practiceForm.getMobile());
        }
        if (practiceForm.getDateOfBirth() != null) {
            dateOfBirth.click();
            datePicker.$("select.react-datepicker__year-select").click();
            datePicker.$(byText(String.valueOf(practiceForm.getDateOfBirth().getYear()))).click();
            datePicker.$("select.react-datepicker__month-select").click();
            datePicker.$(byValue(String.valueOf(practiceForm.getDateOfBirth().getMonth().getValue()))).click();
//            datePicker.$(byTextCaseInsensitive(String.valueOf(practiceForm.getDateOfBirth().getMonth()))).click();
            datePicker.$(byText(String.valueOf(practiceForm.getDateOfBirth().getDayOfMonth()))).click();
        }
        if (practiceForm.getSubjects() != null) {
            subjects.sendKeys(practiceForm.getSubjects());
            subjects.pressEnter();
        }
        if (practiceForm.getHobbies() != null) {
            for (String s : practiceForm.getHobbies()) {
                hobbies.$(byText(s)).click();
            }
        }
        if (practiceForm.getCurrentAddress() != null) {
            currentAddress.sendKeys(practiceForm.getCurrentAddress());
        }
        if (practiceForm.getState() != null) {
            state.scrollIntoView(true).click();
            state.$(byText(practiceForm.getState())).click();
        }
        if (practiceForm.getCity() != null) {
            city.click();
            city.$(byText(practiceForm.getCity())).click();
        }
    }

    public void verifyResults(String key, String value) {
        $(".table-hover").$(byText(key)).parent().$("td+td").shouldHave(text(value));
    }
}
