package concept.functionalInterface;


@FunctionalInterface
public interface FooInterface {
    String printName(String name);

    default String defaultName(){
        return "Jack";
    }
    default String defaultTitle(){
        return "Mr.";
    }

}
