package factory;

import com.github.javafaker.Faker;
import models.User;

import java.text.SimpleDateFormat;

public class UserFactory {
    public static Faker faker = new Faker();

    public static User getRandomUser() {

        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .birthdate(randomBirthDate())
                .streetName(faker.address().streetName())
                .zipCode(faker.address().zipCode())
                .city(faker.address().city())
                .country(faker.address().country())
                .build();
    }

    public static User getAlreadyRegisteredUser() {
        return User.builder()
                .firstName("Mateusz")
                .lastName("B")
                .email("mbukowski2@sii.pl")
                .password("testersii")
                .birthdate("1991-02-17")
                .streetName("Szeligowskiego")
                .zipCode("22-333")
                .city("Lublin")
                .country("Poland")
                .build();
    }

    public static String randomBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(faker.date().birthday());
    }
}
