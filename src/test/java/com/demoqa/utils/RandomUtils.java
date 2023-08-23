package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RandomUtils {


    Faker faker = new Faker(new Locale("EN"));
    public String  firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();

    public String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    public String address = faker.address().city();


    public String getRandomGender() {
        String[] genders = {
                "Male", "Female", "Other"
        };
        return new Faker().options().option(genders);
    }
    public String getRandomHobbies () {
        String[] hobbies = {
                "Sports", "Reading", "Music"
        };
        return new Faker().options().option(hobbies);
    }

    public String getSubject() {
        String[] subject = {
                "Math", "English", "Hindi"
        };
        return new Faker().options().option(subject);
    }

    public String getBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/LLLL/yyyy");
        Faker faker = new Faker();
        return sdf.format(faker.date().birthday());
    }


    private String[] getStateAndCity() {
        String[] state = {
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan"
        };
        String stateValue = new Faker().options().option(state);

        String cityResult = null;
        switch (stateValue) {
            case ("NCR") -> {
                String[] cityNcr = {
                        "Delhi", "Gurgaon", "Noida"
                };
                cityResult = new Faker().options().option(cityNcr);

            }
            case ("Uttar Pradesh") -> {
                String[] cityUttarPradesh = {
                        "Agra", "Lucknow", "Merrut"
                };
                cityResult = new Faker().options().option(cityUttarPradesh);

            }
            case ("Haryana") -> {
                String[] cityHaryana = {
                        "Karnal", "Panipat"
                };
                cityResult = new Faker().options().option(cityHaryana);


            }
            case ("Rajasthan") -> {
                String[] cityRajasthan = {
                        "Jaipur", "Jaiselmer"
                };
                cityResult = new Faker().options().option(cityRajasthan);


            }
        }


        return new String[]{stateValue, cityResult};
    }
    public String[] cityAndState = getStateAndCity();

}
