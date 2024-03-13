package bitwise;

public class Bitwise {

    public static void main(String[] args) {

        /**
         * Left Shift (<<) :
         * The left shift operator (<<) shifts the bits of a number to the left by a specified number of positions.
         * Each bit is shifted to the left by the specified amount, and zeros are added to the right.
         */
        int x = 5; // Binary representation: 000...0000101
        int y = x << 2; // Shift left by 2 positions
        // After shifting left by 2 positions, the binary representation becomes: 000...0010100

        // Multiplication by powers of 2
        /**  5 * 2^2 = 20    **/
        System.out.println(y); // Output: 20

        /**
         * Right Shift (>>):
         * The right shift operator (>>) shifts the bits of a number to the right by a specified number of positions.
         * Each bit is shifted to the right by the specified amount.
         */

        int a = 20; // Binary representation: 000...0010100
        int b = a >> 2; // Shift right by 2 positions
        // After shifting right by 2 positions, the binary representation becomes: 000...0000101

        // Division by powers of 2
        /**  20 / 2^2 = 5    **/
        System.out.println(b); // Output: 5

    }

}
