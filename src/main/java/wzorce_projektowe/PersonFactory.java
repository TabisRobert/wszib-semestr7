package wzorce_projektowe;

import wzorce_projektowe.builder.Address;
import wzorce_projektowe.builder.Person;

public class PersonFactory {

    public Person man(String name, String lastName, Address address, int age){
        return Person.man(name, lastName, address, age);
    }

    public Person woman(String name, String lastName, Address address, int age){
        return Person.woman(name, lastName, address, age);
    }
}
