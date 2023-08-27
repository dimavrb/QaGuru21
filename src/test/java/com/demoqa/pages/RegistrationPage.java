package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.test.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            hobbies = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            subjectsInput = $("#subjectsInput"),
            state = $("#state"),
            city = $("#city"),
            image = $("#uploadPicture"),
            birthDateInput = $("#dateOfBirthInput"),
            submit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        TestBase.closeBanner();
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

    public RegistrationPage setGenderWrapper(String value) {


        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {

        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setHobbies(String value) {

        hobbies.$(byText(value)).click();
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

    public void submit() {
        submit.click();

    }

    public RegistrationPage uploadImage(String value) {

        image.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setBirthDate(String[] birthDate) {
        birthDateInput.click();
        calendar.setDate(birthDate);

        return this;
    }

}




