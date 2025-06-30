package com.myplayground.DesignPatterns.Builder;

public class User {
    private final String name;
    private final String email;
    private final int age;
    private final String address;
    private User(Builder builder) {
        name = builder.name;
        email = builder.email;
        age = builder.age;
        address=builder.address;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " + age + ", " + (address == null ? "N/A" : address);
    }



    public static class Builder {
        public User build() {
            validate();
            return new User(this);
        }

        String name;
        String email;
        int age = -1;
        String address;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        private void validate() {
            if (age < 0) {
                throw new IllegalArgumentException(" Incorrect format of age provided");
            }

            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Incorrect format of name provided ");
            }

            if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                throw new IllegalArgumentException("illegal email format");
            }
        }
    }
}
