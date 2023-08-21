package com.demoqa.tests;

import com.demoqa.pages.registrationPage;
import com.demoqa.pages.registrationResultTable;
import org.junit.jupiter.api.Test;


public class RegistrationFormTests extends TestBase {

    registrationPage registrationPage = new registrationPage();
    registrationResultTable registrationResultTable = new registrationResultTable();

    @Test
    void positiveTestRegistrationForm() {
        registrationPage.openPage()
                .setFirstName("Dmitrii")
                .setLastName("Kalinin")
                .setUserEmailInput("dima@test.ru")
                .setGenterWrapper("Male")
                .setUserNumber("79531453389")
                .setHobbies("[for=hobbies-checkbox-1]")
                .setSubject("Math")
                .setAddress("St. Petersburg")
                .setState("Haryana")
                .setCity("Karnal")
                .uploadImage("test.jpg")
                .setBirthDate("26", "May", "1992")
                .submit();


        registrationResultTable.assertTable("Dmitrii")
        .assertTable("Male")
        .assertTable("7953145338")
        .assertTable("26 May,1992")
        .assertTable("Maths")
        .assertTable("Sports")
        .assertTable("test.jpg")
        .assertTable("St. Petersburg")
        .assertTable("Haryana Karnal");
    }
}