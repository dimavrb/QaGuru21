package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class RegistrationFormTests extends TestBase {

    RegistrationPage RegistrationPage = new RegistrationPage();

    @Test
    void positiveTestRegistrationForm() {
        RegistrationPage.openPage();
        RegistrationPage.setFirstName("Dmitrii");
        RegistrationPage.setLastName("Kalinin");
        RegistrationPage.setUserEmailInput("dima@test.ru");
        RegistrationPage.setGenterWrapper("Male");
        RegistrationPage.setUserNumber("79531453389");
        RegistrationPage.setHobbies("[for=hobbies-checkbox-1]");
        RegistrationPage.setSubject("Math");
        RegistrationPage.setAddress("St. Petersburg");
        RegistrationPage.setState("Haryana");
        RegistrationPage.setCity("Karnal");
        RegistrationPage.uploadImage("test.jpg");
        RegistrationPage.setBirthDate("26", "May", "1992");
        RegistrationPage.submit();


        RegistrationPage.assertTable("Dmitrii");
        RegistrationPage.assertTable("Male");
        RegistrationPage.assertTable("7953145338");
        RegistrationPage.assertTable("26 May,1992");
        RegistrationPage.assertTable("Maths");
        RegistrationPage.assertTable("Sports");
        RegistrationPage.assertTable("test.jpg");
        RegistrationPage.assertTable("St. Petersburg");
        RegistrationPage.assertTable("Haryana Karnal");

    }
}