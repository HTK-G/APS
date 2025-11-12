
import java.io.*;

public class DesolateBruteForce {

    // Count how many 1's are adjacent to at least one 0
    public static int countAdjacentOnes(long num, int totalBits) {
        int count = 0;
        for (int i = 0; i < totalBits; i++) {
            if ((num & (1L << i)) != 0) {  // if bit i is 1
                boolean hasAdjacentZero = false;
                // Check left neighbor
                if (i > 0 && (num & (1L << (i - 1))) == 0) {
                    hasAdjacentZero = true;
                }
                // Check right neighbor
                if (i < totalBits - 1 && (num & (1L << (i + 1))) == 0) {
                    hasAdjacentZero = true;
                }
                if (hasAdjacentZero) {
                    count++;
                }
            }
        }
        return count;
    }

    // Count number of 1's in a number
    public static int countOnes(long num, int totalBits) {
        int count = 0;
        for (int i = 0; i < totalBits; i++) {
            if ((num & (1L << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static long findDesolateNumber(int A, int B) {
        int total = A + B;

        // Edge case
        if (A == 0) {
            return 0;
        }

        long maxNum = (1L << total);
        int maxAdjacent = -1;
        long result = -1;

        // Try all possible numbers
        for (long num = 0; num < maxNum; num++) {
            int ones = countOnes(num, total);
            if (ones == A) {  // Has exactly A ones
                int adjacent = countAdjacentOnes(num, total);
                if (adjacent > maxAdjacent || (adjacent == maxAdjacent && (result == -1 || num < result))) {
                    maxAdjacent = adjacent;
                    result = num;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Generating desolate numbers for A, B from 0 to 20...\n");

        for (int A = 0; A <= 20; A++) {
            for (int B = 0; B <= 20; B++) {
                if (A + B > 20) {
                    continue;  // Skip if total > 20 to save time

                                }long result = findDesolateNumber(A, B);
                System.out.println("A=" + A + ", B=" + B + " => " + result);
            }
        }

        System.out.println("\n\nNow testing specific larger cases...");
        int[][] testCases = {
            {1, 1}, {4, 3}, {4, 1}, {5, 2}, {6, 2}, {3, 4}, {10, 5}
        };

        for (int[] tc : testCases) {
            long result = findDesolateNumber(tc[0], tc[1]);
            System.out.println("A=" + tc[0] + ", B=" + tc[1] + " => " + result);
        }
    }
}
