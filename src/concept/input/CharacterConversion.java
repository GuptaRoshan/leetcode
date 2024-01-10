package concept.input;

public class CharacterConversion {
    public static void main(String[] args) {
        char ch = '3';
        // Converting character to its integer value
        int intValue1 = ch - '0';
        int intValue2 = Character.getNumericValue(ch);
        int intValue3 = Integer.parseInt(Character.toString(ch));
        System.out.println(intValue1);
        System.out.println(intValue2);
        System.out.println(intValue3);
        System.out.println(Character.isDigit(ch));
        System.out.println(Character.isLetter(ch));

        // Converting into ASCII
        int asciiValue = 'a';
        System.out.println(asciiValue);
    }
}
