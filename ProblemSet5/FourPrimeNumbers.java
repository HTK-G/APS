
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FourPrimeNumbers {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        input.close();

        // Sieve to get primes up to M
        boolean[] isComposite = new boolean[M + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= M; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                if ((long) i * i <= M) {
                    for (int j = i * i; j <= M; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }

        // Count distinct prime factors; also track squarefree
        int[] distinctCnt = new int[M + 1];
        boolean[] squarefree = new boolean[M + 1];
        Arrays.fill(squarefree, true);

        for (int p : primes) {
            for (int j = p; j <= M; j += p) {
                distinctCnt[j]++;
            }
            long pp = 1L * p * p;
            if (pp <= M) {
                for (long k = pp; k <= M; k += pp) {
                    squarefree[(int) k] = false;
                }
            }
        }

        int ans = 0;
        for (int n = 2; n <= M; n++) {
            if (squarefree[n] && distinctCnt[n] == 4) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}
