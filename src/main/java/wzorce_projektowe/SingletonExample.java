package wzorce_projektowe;

import java.io.Serializable;

public class SingletonExample implements Serializable {

    //implementacja interfejsu Serializable umożliwia serializację/deserializację

    private static volatile SingletonExample singleSingletonInstance;
    // zmienna statyczna przechowuje jedyną instancję klasy, volatile gwarantuje, że jakakolwiek dokonana zmiana
    // będzie widoczna dla wszystkich wątków
    private SingletonExample(){
    // prywatny konstruktor uniemozliwia bezpośrednie tworzenie instancji klasy
    // rzuca wyjątek przy próbie wykorzystania refleksji
        if (singleSingletonInstance != null){
            throw new RuntimeException("You need to use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonExample getInstance() {
    // jedyny sposób na dostęp do instancji klasy
    // podwójne sprawdzenie czy instancja nie istnieje i blok synchronized aby zabezpieczyć
    // przed jednoczesnym utworzeszniem wielu instancji przez różne wątki
        if (singleSingletonInstance == null) {
            synchronized (SingletonExample.class) {
                if (singleSingletonInstance == null) {
                    singleSingletonInstance = new SingletonExample();
                    // jeśli nie istnieje to tworzona jest jedyna instancja
                }
            }
        }

        return singleSingletonInstance;
    }

    protected SingletonExample readResolve() {
        // metoda z interfejsu Serializable, w przypadku deserializacji wymusza zwrócenie jedynej
        // instancji poprzez użycie getInstance()
        return getInstance();
    }
}
