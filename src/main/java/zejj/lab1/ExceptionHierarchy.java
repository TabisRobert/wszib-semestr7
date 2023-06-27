package zejj.lab1;

import java.util.Scanner;

public class ExceptionHierarchy {
    public static void main(String[] args) {
        try {
            int number = readNumber();
            System.out.println("Wczytana liczba: " + number);
        } catch (NumberIsTooSmallException e) {
            System.out.println("Wprowadzona liczba jest zbyt mała.");
        } catch (NumberIsTooLargeException e) {
            System.out.println("Wprowadzona liczba jest zbyt duża.");
        } catch (NotANumberException e) {
            System.out.println("Wprowadzony tekst nie jest liczbą.");
        } catch (ApplicationException e) {
            System.out.println("Coś poszło nie tak, zepsułeś aplikację");
            throw new RuntimeException(e);
        }
    }

    public static int readNumber() throws ApplicationException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę (od 0 do 10): ");
        String input = scanner.nextLine();

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotANumberException("Wprowadzony tekst nie jest liczbą.");
        }

        if (number < 0) {
            throw new NumberIsTooSmallException("Wprowadzona liczba jest zbyt mała.");
        }

        if (number > 10) {
            throw new NumberIsTooLargeException("Wprowadzona liczba jest zbyt duża.");
        }

        return number;
    }
}
