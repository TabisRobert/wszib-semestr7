package wzorce_projektowe.prototype;

import java.util.Arrays;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        String name = "SomeName";
        int value = 100;

        PrototypeExample example1 = new PrototypeExample(name, value);
        AnotherPrototypeExample example2 = new AnotherPrototypeExample(name, value);

        List<Prototype> prototypes = Arrays.asList(example1, example2);
        List<Prototype> prototypeClones = prototypes.stream()
                .map(Prototype::copy)
                .toList();
        System.out.println(prototypes.get(0).equals(prototypeClones.get(0)));
        System.out.println(prototypes.get(1).equals(prototypeClones.get(1)));
    }
}
