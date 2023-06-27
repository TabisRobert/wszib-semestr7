package zejj.lab4;

import wzorce_projektowe.builder.Address;
import wzorce_projektowe.builder.Gender;
import wzorce_projektowe.builder.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

public class LambdaStreamExample {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        Address hotel = Address.builder()
                .city("Kraków")
                .number(1)
                .postalCode("31-444")
                .street("Rynek")
                .build();

        final Person man = Person.man("Paweł", "Nowak", hotel, 20);
        final Person man1 = Person.man("Grzegorz", "Kowalski", hotel, 21);
        final Person man2 = Person.man("Rafał", "Wójcik", hotel, 30);
        final Person man3 = Person.man("Gaweł", "Wiśniewski", hotel, 45);
        final Person man4 = Person.man("Andrzej", "Lewandowski", hotel, 77);
        final Person woman1 = Person.woman("Grażyna", "Nowak", hotel, 19);
        final Person woman2 = Person.woman("Anna", "Woźniak", hotel, 88);
        final Person woman3 = Person.woman("Barbara", "Kamińska", hotel, 34);
        final Person woman4 = Person.woman("Julia", "Zielińska", hotel, 27);
        final Person woman = Person.woman("Krystyna", "Szymańska", hotel, 52);

        man1.addFriend(man2);
        man2.addFriend(man1);
        man3.addFriend(man4);
        man4.addFriend(man3);

        woman1.addFriend(woman3, woman2, woman4);
        woman2.addFriend(woman3, woman1, woman);
        woman3.addFriend(man, woman1, woman4);
        woman.addFriend(man, man1, man4);
        woman4.addFriend(man, woman1, man4);

        people.add(man);
        people.add(man1);
        people.add(man2);
        people.add(man3);
        people.add(man4);
        people.add(woman);
        people.add(woman1);
        people.add(woman2);
        people.add(woman3);
        people.add(woman4);

        List<Person> females = people.stream()
                .filter(person -> person.getGender() == Gender.FEMALE)
                .toList();
        System.out.println("Kobiety:");
        females.forEach(person -> System.out.println(person.getName() + " " + person.getLastName()));

        List<String> maleLastNames = people.stream()
                .filter(person -> person.getGender() == Gender.MALE)
                .map(Person::getLastName)
                .toList();
        System.out.println("Nazwiska mężczyzn:");
        maleLastNames.forEach(System.out::println);

        int totalAge = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.printf("Suma wieku wszystkich osób: %d%n", totalAge);

        int totalAgeOfGMales = people.stream()
                .filter(person -> person.getGender() == Gender.MALE && person.getName().startsWith("G"))
                .mapToInt(Person::getAge)
                .sum();
        System.out.printf("Suma wieku mężczyzn z imieniem rozpoczynającym się na 'G': %d%n", totalAgeOfGMales);

        List<Person> moreThan2Friends = people.stream()
                .filter(person -> person.getFriends().size() > 2)
                .toList();
        System.out.println("Osoby, których liczba znajomych jest większa niż 2:");
        moreThan2Friends.forEach(person -> System.out.printf("%s %s ma %d przyjaciół%n", person.getName(), person.getLastName(), person.getFriends().size()));

        List<Person> moreFemaleFriends = people.stream()
                .filter(person -> countFemaleFriends(person) > countMaleFriends(person))
                .toList();
        System.out.println("Osoby, których liczba znajomych kobiet jest większa niż mężczyzn:");
        moreFemaleFriends.forEach(person ->
                System.out.printf("%s %s ma %d mężczyzn i %d kobiet wśród przyjaciół%n", person.getName(), person.getLastName(), countMaleFriends(person), countFemaleFriends(person)));

        Set<String> pairOfFriends = people.stream()
                .flatMap(person -> person.getFriends().stream()
                        .filter(friend -> friend.getFriends().contains(person))
                        .map(friend -> {
                            String fullName1 = person.getName() + " " + person.getLastName();
                            String fullName2 = friend.getName() + " " + friend.getLastName();
                            List<String> sortedNames = Stream.of(fullName1, fullName2)
                                    .sorted()
                                    .toList();
                            return sortedNames.get(0) + " i " + sortedNames.get(1);
                        }))
                        .collect(Collectors.toSet());
        System.out.println("Relacje dwustronne:");
        pairOfFriends.forEach(System.out::println);

    }

    public static long countMaleFriends(Person person) {
        return person.getFriends().stream()
                .filter(friend -> friend.getGender() == Gender.MALE)
                .count();
    }

    public static long countFemaleFriends(Person person) {
        return person.getFriends().stream()
                .filter(friend -> friend.getGender() == Gender.FEMALE)
                .count();
    }


}
