package concept.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {

    public static void main(String[] args) {

        /**  Used for side effects, iterating or printing the elements  **/
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("Roshan");

        /**  It is often used when you need to generate or provide values. **/
        Supplier<String> supplier = () -> "Hello world";
        System.out.println(supplier.get());

        /** It is used for transforming data. **/
        Function<String, String> function = (name) -> name.toLowerCase();
        System.out.println(function.apply("roshan"));

        /**  It is often used for filtering or testing conditions. **/
        Predicate<Integer> predicate = (i) -> i % 2 == 0;
        System.out.println(predicate.test(3));

    }
}
