
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

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
