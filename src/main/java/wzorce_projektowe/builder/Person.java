package wzorce_projektowe.builder;

public class Person {

    private final String name;
    private final String lastName;
    private final Gender gender;
    private final Address address;
    private final int age;

    private Person(String name, String lastName, Gender gender, Address address, int age) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public Person.Builder builder() {
        return new Person.Builder();
    }

    public static Person man(
            String firstName,
            String lastName,
            Address address,
            int age
    ) {
        return new Person(firstName, lastName, Gender.MALE, address, age);
    }

    public static Person woman(
            String firstName,
            String lastName,
            Address address,
            int age
    ) {
        return new Person(firstName, lastName, Gender.FEMALE, address, age);
    }

    public static class Builder {
        private String name;
        private String lastName;
        private Gender gender;
        private Address address;
        private int age;

        public Person build() {
            return new Person(name, lastName, gender, address, age);
        }

        public Builder firstName(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Address.Builder addressBuilder() {
            return Address.builder();
        }

    }
}
