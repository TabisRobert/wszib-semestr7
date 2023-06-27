package wzorce_projektowe.builder;

public class Address {

    private final String city;
    private final String street;
    private final String postalCode;
    private final int number;

    private Address(final String city, final String street, final String postalCode, final int number) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
    }

    public static Address.Builder builder() {
        return new Address.Builder();
    }

    public static final class Builder {
        private String city;
        private String street;
        private String postalCode;
        private int number;

        public Address build() {
            return new Address(city, street, postalCode, number);
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder street(String street){
            this.street = street;
            return this;
        }
        public Builder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }
        public Builder number(int number){
            this.number = number;
            return this;
        }
    }
}
