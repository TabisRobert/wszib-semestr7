package zejj.lab1;

// Wyjątek w przypadku zbyt dużej liczby
class NumberIsTooLargeException extends ApplicationException {
    public NumberIsTooLargeException(String message) {
        super(message);
    }
}
