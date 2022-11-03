package providers;

import com.github.javafaker.Faker;

public class DataProvider {
    Faker faker = new Faker();

    public String setFirstName() {
        return faker.name().firstName();
    }
    public String setLastName() {
        return faker.name().lastName();
    }

    public String setEmail() {
        return faker.internet().emailAddress();
    }

    public String setPassword() {
        return faker.internet().password();
    }
    public String setBirthdate() {
        return faker.date().birthday(18,60).toString();
    }

}
