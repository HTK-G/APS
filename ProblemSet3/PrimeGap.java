
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeGap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        input.close();

        // Edge check:
        if (a >= b) {
            System.out.println(-1);
            return;
        }

        int bound = (int) Math.sqrt(b) + 1;
        ArrayList<Integer> basePrimes = sieve(bound);

        // Calculation steps:
        boolean[] primes = new boolean[(int) (b - a + 1)]; // this track only [a, b]
        Arrays.fill(primes, true);

        for (int p : basePrimes) {
            // find the first multiple of p in [a, b]
            long start = Math.max((long) p * p, ((a + p - 1) / p) * (long) p);
            for (long j = start; j <= b; j += p) {
                primes[(int) (j - a)] = false;
            }
        }
        if (a == 1) {
            primes[0] = false;
        }

        int prev = -1;
        int[] minPair = new int[]{-1, -1};
        int[] maxPair = new int[]{-1, -1};

        for (int i = 0; i < b - a + 1; i++) {
            if (primes[i]) {
                int current = (int) (i + a);
                if (prev != -1) {
                    int gap = current - prev;
                    // update min pair
                    if (minPair[0] == -1 || gap < (minPair[1] - minPair[0])) {
                        minPair[0] = prev;
                        minPair[1] = current;
                    }
                    // update max pair
                    if (maxPair[0] == -1 || gap > (maxPair[1] - maxPair[0])) {
                        maxPair[0] = prev;
                        maxPair[1] = current;
                    }
                }
                prev = current;
            }
        }

        // output section
        if (minPair[0] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minPair[0] + " " + minPair[1] + " " + maxPair[0] + " " + maxPair[1]);
        }
    }

    public static ArrayList<Integer> sieve(int bound) {

        boolean[] prime = new boolean[bound];

        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        int limit = (int) Math.sqrt(prime.length);
        for (int i = 2; i < limit; i++) {

            if (prime[i]) {

                for (int j = i * i; j < prime.length; j += i) {

                    prime[j] = false;
                }
            }
        }

        ArrayList<Integer> basePrimes = new ArrayList<>();

        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                basePrimes.add(i);
            }
        }
        return basePrimes;
    }

}

/*
public static void main(String[] args) {
        // Input section:
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        // Edge case check
        if (a >= b) {
            System.out.println(-1);
            input.close();
            return;
        }

        if (b < Math.sqrt(Integer.MAX_VALUE)) {
            smallNumber(a, b);
        } else {
            largeNumber(a, b);
        }
        input.close();
    }

    public static void largeNumber(int a, int b) {
        System.out.println("large Number");
    }

    public static void smallNumber(int a, int b) {
        int[] maxPair = new int[2];
        int[] minPair = new int[2];

        boolean[] primes = new boolean[b + 1];

        // Calculation Section:
        sieve(primes); // to get a ful list of

        int i = a;
        while (!primes[i] && i <= b) {
            i++;
        }
        if (!primes[i]) {
            // This means there's no prime in range(a, b)
            System.out.println(-1);
            return;
        }
        // At here, i should be the first prime number in range(a, b)
        int first = i;
        int second = first;
        maxPair[0] = first;
        maxPair[1] = first;
        minPair[0] = a;
        minPair[1] = b;

        for (i = i + 1; i <= b; i++) {
            if (primes[i]) {
                first = second;
                second = i;
                int gap = second - first;

                if (gap < minPair[1] - minPair[0]) {
                    minPair[0] = first;
                    minPair[1] = second;
                }
                if (gap > maxPair[1] - maxPair[0]) {
                    maxPair[0] = first;
                    maxPair[1] = second;
                }
            }
        }

        // Output section:
        if (second == first) {
            System.out.println(-1);
            return;
        }
        System.out.println(minPair[0] + " " + minPair[1] + " " + maxPair[0] + " " + maxPair[1]);
    }

    // Helper method of the sieve approach: O(N * log(log N))
    public static void sieve(boolean[] primes) {

        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < primes.length; i++) {

            if (primes[i]) {
                long start = (long) i * i;
                if (start > primes.length) {
                    break;
                }
                for (long j = start; j < primes.length; j += i) {
                    primes[(int) j] = false;
                }
            }
        }
    }
 */
