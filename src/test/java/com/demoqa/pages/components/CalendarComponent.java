package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    public void setDate(String[] birthDate) {

        String day = birthDate[0];
        String month = birthDate[1];
        String year = birthDate[2];
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();


    }
}