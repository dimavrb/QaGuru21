package com.demoqa.test;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.RegistrationResultTableComponent;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultTableComponent registrationResultTable = new RegistrationResultTableComponent();

    RandomUtils randomUtils = new RandomUtils();



    @Test
    @Tag("RegistrationForm")
    void positiveTestRegistrationForm() {


        step("Открытие страницы", () ->registrationPage.openPage());
        step("Заполнение поля - имя", () ->registrationPage.setFirstName(randomUtils.firstName));
        step("Заполнение поля - фамилия", () ->registrationPage.setLastName(randomUtils.lastName));
        step("Заполнение поля - почта", () ->registrationPage.setUserEmailInput(randomUtils.email));
        step("Заполнение поля - пол", () ->registrationPage.setGenderWrapper(randomUtils.randomGender));
        step("Заполнение поля - телефон", () ->registrationPage.setUserNumber(randomUtils.mobilePhone));
        step("Заполнение поля - дата рождения", () ->registrationPage.setBirthDate(randomUtils.birthDate));
        step("Заполнение поля - subject", () ->registrationPage.setSubject(randomUtils.subject));
        step("Заполнение поля - хобби", () ->registrationPage.setHobbies(randomUtils.randomHobbies));
        step("Заполнение поля - фото", () ->registrationPage.uploadImage(randomUtils.image));
        step("Заполнение поля - адрес", () ->registrationPage.setAddress(randomUtils.address));
        step("Нажатие кнопки подтверждения", () ->registrationPage.submit());


        step("Проверка поля - имя", () ->registrationResultTable.assertTable(randomUtils.firstName));
        step("Проверка поля - фамилия", () ->registrationResultTable.assertTable(randomUtils.lastName));
        step("Проверка поля - почта", () ->registrationResultTable.assertTable(randomUtils.email));
        step("Проверка поля - пол", () ->registrationResultTable.assertTable(randomUtils.randomGender));
        step("Проверка поля - телефон", () ->registrationResultTable.assertTable(randomUtils.mobilePhone));
        step("Проверка поля - дата рождения", () ->registrationResultTable.assertTable(randomUtils.birthDate[0] + " " + randomUtils.birthDate[1] + "," + randomUtils.birthDate[2]));
        step("Проверка поля - subject", () ->registrationResultTable.assertTable(randomUtils.subject));
        step("Проверка поля - хобби", () ->registrationResultTable.assertTable(randomUtils.randomHobbies));
        step("Проверка поля - фото", () ->registrationResultTable.assertTable(randomUtils.image));
        step("Проверка поля - адрес", () ->registrationResultTable.assertTable(randomUtils.address));

    }
}