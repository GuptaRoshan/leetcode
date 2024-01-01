package concept.generics;

class Box<T> {
    private T value;

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public <T> T genericMethod(T argument) {
        return argument;
    }
}

class TestGeneric {
    public static void main(String[] args) {
        /**
         Java generics allow you to create classes, interfaces, and
         methods that operate on types without specifying the actual type until the code is used.
         This helps in writing more generic and reusable code.
         **/

        // Creating a Box for Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(10);
        System.out.println("Integer Value: " + integerBox.getValue());

        // Creating a Box for String
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics!");
        System.out.println("String Value: " + stringBox.getValue());

        // Invoking Generic Method
        System.out.println("Generic Method Value: " + integerBox.genericMethod("genericMethod"));

    }
}
