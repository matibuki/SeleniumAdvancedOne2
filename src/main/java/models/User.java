package models;

import providers.DataProvider;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;

    private User() {

    }

    public static final class UserBuilder {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getBirthdate() {
            return birthdate;
        }

        private String email;
        private String password;
        private String birthdate;

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder birthdate(String birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public static UserBuilder builder() {
            return new UserBuilder();
        }

        public User build() {
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || birthdate.isEmpty()) {
                throw new IllegalStateException("Fields cannot be empty");
            }
            return user;
        }

        DataProvider userDataCreator = new DataProvider();
        User user = UserBuilder.builder()
                .firstName(userDataCreator.setFirstName())
                .lastName(userDataCreator.setLastName())
                .email(userDataCreator.setEmail())
                .password(userDataCreator.setPassword())
                .birthdate(userDataCreator.setBirthdate())
                .build();
    }


}
