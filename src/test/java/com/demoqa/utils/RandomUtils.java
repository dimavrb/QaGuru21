package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;

public class RandomUtils {


    public String image = "test.jpg";
    Faker faker = new Faker(new Locale("EN"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    public String address = faker.address().city();
    public String randomGender = getRandomGender();
    public String randomHobbies = getRandomHobbies();
    public String subject = getSubject();
    private final Dictionary<String, String> getStateAndCity = generateStateAndCity();
    public String state = getStateAndCity.get("State");
    public String city = getStateAndCity.get("City");
    public String[] birthDate = randomBirthDate();

    private String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    private String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    private String getSubject() {
        String[] subject = {"Math", "English", "Hindi"};
        return faker.options().option(subject);
    }

    private String[] randomBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd LLLL yyyy", Locale.ENGLISH);
        String calendarDate = sdf.format(faker.date().birthday());

        return calendarDate.split(" ");
    }


    private Dictionary<String, String> generateStateAndCity() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String stateValue = faker.options().option(state);

        String cityValue = null;
        switch (stateValue) {
            case "NCR" : {
                String[] cityNcr = {"Delhi", "Gurgaon", "Noida"};
                cityValue = faker.options().option(cityNcr);
            }


            case "Uttar Pradesh" : {
                String[] cityUttarPradesh = {"Agra", "Lucknow", "Merrut"};
                cityValue = faker.options().option(cityUttarPradesh);

            }
            case "Haryana" : {
                String[] cityHaryana = {"Karnal", "Panipat"};
                cityValue = faker.options().option(cityHaryana);


            }
            case "Rajasthan" : {
                String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
                cityValue = faker.options().option(cityRajasthan);


            }
        }

        Dictionary<String, String> stateAndCity = new Hashtable<>();
        stateAndCity.put("State", stateValue);
        stateAndCity.put("City", cityValue);
        return stateAndCity;
    }


}
