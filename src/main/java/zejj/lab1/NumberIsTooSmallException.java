package zejj.lab1;

// Wyjątek w przypadku zbyt małej liczby
class NumberIsTooSmallException extends ApplicationException {
    public NumberIsTooSmallException(String message) {
        super(message);
    }
}
