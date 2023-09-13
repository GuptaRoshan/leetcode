package dp;

import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {
        int offset = 1;
        int[] bits = new int[n + 1];
        Arrays.fill(bits, 0);
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            bits[i] = bits[i - offset] + 1;

        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
}
