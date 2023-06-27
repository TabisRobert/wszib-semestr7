package wzorce_projektowe.prototype;

import lombok.Getter;

@Getter
public class PrototypeExample extends Prototype {

    private final String description;

    public PrototypeExample(String name, int value) {
        super(name, value);
        this.description = "Prototype Example";
    }

    @Override
    public Prototype copy() {
        return new PrototypeExample(this.getName(), this.getValue());
    }
}
