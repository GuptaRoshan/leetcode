package concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DoubleColon {

    // static function to be called
    static void staticFunction(String s) {
        System.out.println(s);
    }

    // instance function to be called
    void instanceFunction(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        // Get the stream
        Stream<String> stream = Stream.of("Geeks", "For", "Geeks", "A", "Computer", "Portal");
        // Print the stream
        stream.forEach(System.out::println);

        List<String> list = new ArrayList<>(Arrays.asList("Geeks", "For", "Geeks", "A", "Computer", "Portal"));

        // To call static function
        list.forEach(DoubleColon::staticFunction);
        // To call instance function
        list.forEach( (new  DoubleColon())::instanceFunction);

    }
}
