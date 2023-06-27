package wzorce_projektowe.prototype;

import lombok.Getter;

@Getter
public class AnotherPrototypeExample extends Prototype{

    private final String description;

    public AnotherPrototypeExample(String name, int value) {
        super(name, value);
        this.description = "Another Prototype Example";
    }

    @Override
    public Prototype copy() {
        return new AnotherPrototypeExample(this.getName(), this.getValue());
    }
}
