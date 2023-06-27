package zejj.lab1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskNumberOne {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(TaskNumberOne.class.getName());

        try {
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;

            // Rzucanie wyjątkiem dla liczby parzystej
            if (randomNumber % 2 == 0) {
                throw new BadLuckException("Wylosowano parzystą liczbę", randomNumber);
            }
        } catch (BadLuckException e) {
            // Obsługa wyjątku za pomocą logu stacktrace
            logger.log(Level.SEVERE, "Wystąpił wyjątek: " + e.getMessage() + ". Wylosowana liczba: " + e.getNumber(), e);
        } finally {
            System.out.println("A ja się zawsze wywołuję");
        }
    }
}
