package concept.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardExample {


    /**
     * Unbounded Wildcard (?):
     * <p>
     * In this example, the printList method accepts a list with an unbounded wildcard (List<?>).
     * It can accept lists of any type, but it doesn't know the specific type.
     **/

    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }


    /**
     * Bounded Wildcard (? extends T):
     * <p>
     * In this example, the sumOfList method accepts a list with a bounded wildcard (List<? extends Number>).
     * It can accept lists of any type that is a subtype of Number.
     * This is useful when you want to perform operations that require a specific superclass.
     **/

    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    /**
     * Lower Bounded Wildcard (? super T):
     * <p>
     * In this example, the sumOfList method accepts a list with a bounded wildcard (List<? extends Number>).
     * It can accept lists of any type that is a subtype of Number.
     * This is useful when you want to perform operations that require a specific superclass.
     **/

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        printList(list);
        System.out.println(sumOfList(list));

        List<Number> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        addNumbers(list2);
    }

}
