package demoQA.pages;

import com.codeborne.selenide.SelenideElement;
import demoQA.models.M_PracticeForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    ClassLoader cl = PracticeFormPage.class.getClassLoader();

    SelenideElement submitForm = $(".table-hover");
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
            datePicker.$(byValue(String.valueOf(practiceForm.getDateOfBirth().getMonth().getValue() - 1))).click();
//            datePicker.$(byTextCaseInsensitive(String.valueOf(practiceForm.getDateOfBirth().getMonth()))).click();
            datePicker.$(byText(String.valueOf(practiceForm.getDateOfBirth().getDayOfMonth()))).click();
        }
        if (practiceForm.getSubjects() != null) {
            for (String s : practiceForm.getSubjects()) {
                subjects.sendKeys(s);
                subjects.pressEnter();
            }
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
        submitForm.$(byText(key)).parent().$("td+td").shouldHave(text(value));
    }

    public void verifyResults(M_PracticeForm expFields) throws IOException {
        try (InputStream is = cl.getResourceAsStream("PracticeFormValidationFields.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)))
        ) {
            String field = reader.readLine();
            if (expFields.getFirstName() != null && expFields.getLastName() != null) {
                verifyResults(field, expFields.getFirstName() + " " + expFields.getLastName());
            }
            field = reader.readLine();
            if (expFields.getEmail() != null) {
                verifyResults(field, expFields.getEmail());
            }
            field = reader.readLine();
            if (expFields.getGender() != null) {
                verifyResults(field, expFields.getGender());
            }
            field = reader.readLine();
            if (expFields.getMobile() != null) {
                verifyResults(field, expFields.getMobile());
            }
            field = reader.readLine();
            if (expFields.getDateOfBirth() != null) {
                DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd MMMM,yyyy").withLocale(Locale.UK);
                verifyResults(field, expFields.getDateOfBirth().format(dateformat));
            }
            field = reader.readLine();
            if (expFields.getSubjects() != null) {
                StringJoiner joiner = new StringJoiner(", ");
                for (String s : expFields.getSubjects()) {
                    joiner.add(s);
                }
                verifyResults(field, joiner.toString());
            }
            field = reader.readLine();
            if (expFields.getHobbies() != null) {
                StringJoiner joiner = new StringJoiner(", ");
                for (String s : expFields.getHobbies()) {
                    joiner.add(s);
                }
                verifyResults(field, joiner.toString());
            }
            field = reader.readLine();
            if (expFields.getCurrentAddress() != null) {
                verifyResults(field, expFields.getCurrentAddress());
            }
            field = reader.readLine();
            if (expFields.getState() != null && expFields.getCity() != null) {
                verifyResults(field, expFields.getState() + " " + expFields.getCity());
            }
        }
    }
}
