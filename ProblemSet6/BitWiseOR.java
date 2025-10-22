
import java.util.Scanner;

public class BitWiseOR {

    public static void main(String[] args) {

        // Notice: a ground truth ->
        // 1000 0000 is bigger than 0111 1111. This is the key
        // So moving from MSB to LSB is the way.
        // We are not looking for how many 1s but how big the 1 represents.
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long L = in.nextLong();
        long R = in.nextLong();
        in.close();

        if (L == R) {                      // trivial case
            System.out.println(L);
            return;
        }

        long x = L;                        // start from the smallest allowed

        // Try to set beneficial bits (where N has 0) from high to low
        for (int i = 62; i >= 0; i--) {
            long bit = 1L << i;

            // Only a candidate if N's bit is 0 and x's bit is 0
            if ((N & bit) == 0 && (x & bit) == 0) {
                long cand = x | bit;               // flip this bit on
                // keep x minimal by zeroing all lower bits
                cand &= ~((bit) - 1);              // lower bits -> 0

                if (cand <= R) {                   // feasible inside [L, R]
                    x = cand;                      // accept the flip
                }
            }
        }

        System.out.println(x);
    }

}

/*
 *     public static void main(String[] args) {
        // We want to maximize the 1s after the change

        // input section:
        Scanner input = new Scanner(System.in);
        long N = input.nextLong();
        long L = input.nextLong();
        long R = input.nextLong();
        input.close();

        if (L == R) {
            System.out.println(L);
            return;
        }

        long max = L | N;
        long x = L;

        // calculation steps:
        for (long i = L + 1; i <= R; i++) {

            if ((i | N) > max) {
                max = (i | N);
                x = i;
            }
        }
        // output section:
        System.out.println(x);
    }
 */
