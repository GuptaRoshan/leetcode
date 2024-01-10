package concept.input;

public class Conversion {
    public static void main(String[] args) {
        // Auto-boxing: converting int to Integer
        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt; // Auto-boxing


        // Auto-unboxing: converting Integer to int
        Integer wrappedIntObj = 42;
        int primitiveInt2 = wrappedIntObj; // Auto-unboxing


        // Conversion
        int intValue = 42;
        long longValue = intValue; // Implicit cast from int to long

        long longValue2 = 1234567890123L;
        int intValue2 = (int) longValue; // Explicit cast from long to int

        String strNumber = "123";
        int intValue3 = Integer.parseInt(strNumber);

        String strDouble = "3.14";
        double doubleValue = Double.parseDouble(strDouble);

        int intValue4 = 42;
        String strValue = Integer.toString(intValue);

        double doubleValue3 = 3.14;
        String strValue2 = Double.toString(doubleValue);

    }
}
