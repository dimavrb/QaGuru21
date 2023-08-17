package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            hobbies = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            subjectsInput = $("#subjectsInput"),
            state = $("#state"),
            city = $("#city"),
            image = $("#uploadPicture"),
            birthDateInput = $("#dateOfBirthInput"),
            submit = $("#submit"),
            table = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {

        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {

        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmailInput(String value) {

        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGenterWrapper(String value) {


        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {

        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setHobbies(String value) {

        hobbies.$(value).click();
        return this;
    }

    public RegistrationPage setSubject(String value) {

        subjectsInput.val(value).pressEnter();

        return this;
    }

    public RegistrationPage setAddress(String value) {

        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.scrollTo();
        state.click();
        state.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submit.click();

        return this;
    }

    public RegistrationPage uploadImage(String value) {

        image.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage assertTable(String value) {
        table.shouldHave(text(value));

        return this;
    }
}




