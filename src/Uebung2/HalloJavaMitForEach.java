package Uebung2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }

        //Beide Befehle sind das gleiche
        stringList.forEach((String s) -> System.out.println(s));
        Consumer<String> consumer = (String s) -> System.out.println(s);
        stringList.forEach(System.out::println);
    }
}
