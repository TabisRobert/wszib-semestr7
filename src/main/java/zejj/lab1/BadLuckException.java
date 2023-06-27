package zejj.lab1;

import lombok.Getter;

@Getter
public class BadLuckException extends Exception{

    private final int number;
    public BadLuckException(String message, int number) {
        super(message);
        this.number = number;
    }
}
