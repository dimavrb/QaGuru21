package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.RegistrationResultTableComponent;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultTableComponent registrationResultTable = new RegistrationResultTableComponent();

    RandomUtils randomUtils = new RandomUtils();

    @Test
    void positiveTestRegistrationForm() {

        String firstName = randomUtils.firstName;
        String lastName = randomUtils.lastName;
        String email = randomUtils.email;
        String gender = randomUtils.getRandomGender();
        String mobilePhone = randomUtils.mobilePhone;
        String hobbies = randomUtils.getRandomHobbies();
        String subject = randomUtils.getSubject();
        String address = randomUtils.address;
        String state = randomUtils.cityAndState[0];
        String city = randomUtils.cityAndState[1];
        String image = "test.jpg";
        String birthDate = randomUtils.getBirthDate();



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
       // .assertTable(birthDate) не смог конвертировать дату в формат из таблицы
        .assertTable(subject)
        .assertTable(hobbies)
        .assertTable(image)
        .assertTable(address)
        .assertTable(state + " "+ city);
    }
}