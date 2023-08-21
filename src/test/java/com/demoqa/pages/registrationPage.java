package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class registrationPage {
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
            submit = $("#submit");

    public registrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public registrationPage setFirstName(String value) {

        firstNameInput.setValue(value);

        return this;
    }

    public registrationPage setLastName(String value) {

        lastNameInput.setValue(value);

        return this;
    }

    public registrationPage setUserEmailInput(String value) {

        userEmailInput.setValue(value);

        return this;
    }

    public registrationPage setGenterWrapper(String value) {


        genterWrapper.$(byText(value)).click();

        return this;
    }

    public registrationPage setUserNumber(String value) {

        userNumber.setValue(value);

        return this;
    }

    public registrationPage setHobbies(String value) {

        hobbies.$(value).click();
        return this;
    }

    public registrationPage setSubject(String value) {

        subjectsInput.val(value).pressEnter();

        return this;
    }

    public registrationPage setAddress(String value) {

        currentAddress.setValue(value);
        return this;
    }

    public registrationPage setState(String value) {
        state.scrollTo();
        state.click();
        state.$(byText(value)).click();

        return this;
    }

    public registrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();

        return this;
    }

    public registrationPage submit() {
        submit.click();

        return this;
    }

    public registrationPage uploadImage(String value) {

        image.uploadFromClasspath(value);

        return this;
    }

    public registrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

}




