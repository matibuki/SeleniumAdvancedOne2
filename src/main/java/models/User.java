package models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;
    private String streetName;
    private String zipCode;
    private String city;
    private String country;

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

    public String getStreetName() {
        return streetName;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }

    private User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static final class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthdate;
        private String streetName;
        private String zipCode;
        private String city;
        private String country;

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

        public UserBuilder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }
        public UserBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }
        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }
        public UserBuilder country(String country) {
            this.country = country;
            return this;
        }

        public User build() {
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                throw new IllegalStateException("Fields cannot be empty");
            }

            User user = new User();
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.email = this.email;
            user.password = this.password;
            user.birthdate = this.birthdate;
            user.streetName = this.streetName;
            user.zipCode = this.zipCode;
            user.city = this.city;
            user.country = this.country;

            return user;
        }
    }
}
