package com.demoqa.test;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.RegistrationResultTableComponent;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultTableComponent registrationResultTable = new RegistrationResultTableComponent();

    RandomUtils randomUtils = new RandomUtils();


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

    String image = randomUtils.image;

    String[] birthDate = (randomUtils.birthDate);

    @Test
    void positiveTestRegistrationForm() {


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmailInput(email)
                .setGenderWrapper(gender)
                .setUserNumber(mobilePhone)
                .setBirthDate(birthDate)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadImage(image)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();


        registrationResultTable.assertTable(firstName)
                .assertTable(lastName)
                .assertTable(email)
                .assertTable(gender)
                .assertTable(mobilePhone)
                .assertTable(birthDate[0] + " " + birthDate[1] + "," + birthDate[2])
                .assertTable(subject)
                .assertTable(hobbies)
                .assertTable(image)
                .assertTable(address)
                .assertTable(state + " " + city);
    }
}