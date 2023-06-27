package zejj.lab1;

// Wyjątek w przypadku niepoprawnej liczby
class NotANumberException extends ApplicationException {
    public NotANumberException(String message) {
        super(message);
    }
}
