package concept.functionalInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckLambdas {

    public static void main(String[] args){
        FooInterface fooInterface = (name) -> "Hello " + name;

        System.out.println(fooInterface.printName("Roshan"));
        System.out.println(fooInterface.defaultName());
        System.out.println(fooInterface.defaultTitle());

    }

}
