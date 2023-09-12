package com.demoqa.test;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.RegistrationResultTableComponent;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultTableComponent registrationResultTable = new RegistrationResultTableComponent();

    RandomUtils randomUtils = new RandomUtils();



    @Test
    @Tag("RegistrationForm")
    void positiveTestRegistrationForm() {


        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmailInput(randomUtils.email)
                .setGenderWrapper(randomUtils.randomGender)
                .setUserNumber(randomUtils.mobilePhone)
                .setBirthDate(randomUtils.birthDate)
                .setSubject(randomUtils.subject)
                .setHobbies(randomUtils.randomHobbies)
                .uploadImage(randomUtils.image)
                .setAddress(randomUtils.address)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .submit();


        registrationResultTable.assertTable(randomUtils.firstName)
                .assertTable(randomUtils.lastName)
                .assertTable(randomUtils.email)
                .assertTable(randomUtils.randomGender)
                .assertTable(randomUtils.mobilePhone)
                .assertTable(randomUtils.birthDate[0] + " " + randomUtils.birthDate[1] + "," + randomUtils.birthDate[2])
                .assertTable(randomUtils.subject)
                .assertTable(randomUtils.randomHobbies)
                .assertTable(randomUtils.image)
                .assertTable(randomUtils.address)
                .assertTable(randomUtils.state + " " + randomUtils.city);
    }
}