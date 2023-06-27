package wzorce_projektowe.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Prototype {

    public String name;
    public int value;

    public abstract Prototype copy();

}
