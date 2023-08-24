package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.RegistrationResultTableComponent;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;



public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultTableComponent registrationResultTable = new RegistrationResultTableComponent();

    RandomUtils randomUtils = new RandomUtils();

    TestData testData = new TestData();
    private class TestData {

        String firstName = randomUtils.firstName;
        String lastName = randomUtils.lastName;
        String email = randomUtils.email;
        String gender = randomUtils.randomGender;
        String mobilePhone = randomUtils.mobilePhone;
        String hobbies = randomUtils.randomHobbies;
        String subject = randomUtils.subject;
        String address = randomUtils.address;
        String state = randomUtils.state;
        String city = randomUtils.city;

        String image = "test.jpg";

        String[] birthDate = (randomUtils.birthDate);
    }

    @Test
    void positiveTestRegistrationForm() {





        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmailInput(testData.email)
                .setGenderWrapper(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .setBirthDate(testData.birthDate)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadImage(testData.image)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();


        registrationResultTable.assertTable(testData.firstName)
        .assertTable(testData.lastName)
        .assertTable(testData.email)
        .assertTable(testData.gender)
        .assertTable(testData.mobilePhone)
        .assertTable(testData.birthDate[0]+" "+testData.birthDate[1]+","+testData.birthDate[2])
        .assertTable(testData.subject)
        .assertTable(testData.hobbies)
        .assertTable(testData.image)
        .assertTable(testData.address)
        .assertTable(testData.state + " "+ testData.city);
    }
}