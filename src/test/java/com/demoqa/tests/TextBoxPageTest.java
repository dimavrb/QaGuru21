package com.demoqa.tests;


import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;


public class TextBoxPageTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void positiveTestRegistrationForm() {

    textBoxPage.openPage();
    textBoxPage.setFullName("Dmitrii Kalinin");
    textBoxPage.setEmail("dima@mail.ru");
    textBoxPage.setCurrentAddress("Krasnodar");
    textBoxPage.setPermanentAddress("St.Petersburg");
    textBoxPage.submit();
    textBoxPage.assertTable("Dmitrii Kalinin");
    textBoxPage.assertTable("dima@mail.ru");
    textBoxPage.assertTable("Krasnodar");
    textBoxPage.assertTable("St.Petersburg");


    }
}